package org.chervyakovsky.customarray.main;

import org.chervyakovsky.customarray.config.RepositoryConfig;
import org.chervyakovsky.customarray.config.WarehouseConfig;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.entity.Warehouse;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.observer.CustomArrayObserver;
import org.chervyakovsky.customarray.observer.impl.CustomArrayObserverImpl;
import org.chervyakovsky.customarray.repository.Repository;
import org.chervyakovsky.customarray.repository.impl.RepositoryImpl;
import org.chervyakovsky.customarray.service.ReplaceService;
import org.chervyakovsky.customarray.service.impl.customImpl.ReplaceServiceCustomImpl;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String fileName = "./src/main/resources/data/data.txt";
        Repository repository = RepositoryConfig.configure(fileName);
        Warehouse warehouse = WarehouseConfig.configure(repository.getAll());
        CustomArrayObserver observer = new CustomArrayObserverImpl();
        repository.forEach(array -> array.attach(observer));
        System.out.println(repository);
        System.out.println(warehouse);
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
    }
}
