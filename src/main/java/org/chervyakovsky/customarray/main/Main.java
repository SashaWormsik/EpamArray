package org.chervyakovsky.customarray.main;

import org.chervyakovsky.customarray.comparator.CustomArrayComparator;
import org.chervyakovsky.customarray.config.RepositoryConfig;
import org.chervyakovsky.customarray.config.WarehouseConfig;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.entity.Warehouse;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.observer.CustomArrayObserver;
import org.chervyakovsky.customarray.observer.impl.CustomArrayObserverImpl;
import org.chervyakovsky.customarray.repository.Repository;
import org.chervyakovsky.customarray.service.ReplaceService;
import org.chervyakovsky.customarray.service.impl.customImpl.ReplaceServiceCustomImpl;

public class Main {
    public static void main(String[] args) {
        String fileName = "./src/main/resources/data/data.txt";
        Repository repository = RepositoryConfig.configure(fileName);
        Warehouse warehouse = WarehouseConfig.configure(repository.getAll());
        CustomArrayObserver observer = new CustomArrayObserverImpl();
        repository.forEach(array -> array.attach(observer));
        ReplaceService replaceService = new ReplaceServiceCustomImpl();
        repository.forEach(array -> {
            try {
                replaceService.replaceNegativeValue(array, 555);
            } catch (CustomException e) {
                e.printStackTrace();
            }
        });
        System.out.println(repository);
        System.out.println(warehouse);
        repository.add(null);
        int[] i = null;
        CustomArray array = new CustomArray(i);
        repository.add(array);
        System.out.println(repository.sort(CustomArrayComparator.COUNT_ELEMENT));
        System.out.println(repository.sort(CustomArrayComparator.FIRST_ELEMENT));
    }
}
