package org.chervyakovsky.customarray.repository.impl;

import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.repository.Repository;
import org.chervyakovsky.customarray.repository.Specification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class RepositoryImpl implements Repository {

    private static RepositoryImpl instance;
    private List<CustomArray> customArrayList;

    private RepositoryImpl() {
        customArrayList = new ArrayList<>();
    }

    public static RepositoryImpl getInstance() {
        if (instance == null) {
            instance = new RepositoryImpl();
        }
        return instance;
    }

    @Override
    public boolean add(CustomArray customArray) {
        return this.customArrayList.add(customArray);
    }

    @Override
    public boolean addAll(Collection<CustomArray> collectionCustomArray) {
        return this.customArrayList.addAll(collectionCustomArray);
    }

    @Override
    public boolean remove(CustomArray customArray) {
        return this.customArrayList.remove(customArray);
    }

    @Override
    public boolean removeAll(Collection<CustomArray> collectionCustomArray) {
        return customArrayList.removeAll(collectionCustomArray);
    }

    @Override
    public CustomArray get(int index) {
        return this.customArrayList.get(index);
    }

    @Override
    public List<CustomArray> getAll() {
        return this.customArrayList;
    }

    @Override
    public CustomArray set(int index, CustomArray customArray) {
        return this.customArrayList.set(index, customArray);
    }

    @Override
    public List<CustomArray> query(Specification specification) {
        List<CustomArray> queryResult = this.customArrayList.stream()
                .filter(customArray -> specification.specify(customArray))
                .collect(Collectors.toList());
        return queryResult;
    }

    @Override
    public List<CustomArray> sort(Comparator<CustomArray> comparator) {
        //this.customArrayList.sort(comparator);
        return this.customArrayList.stream()
                .sorted(Comparator.nullsLast(comparator)) // FIXME решение для сортировки с NULL
                .collect(Collectors.toList());
    }

    public void forEach(Consumer<? super CustomArray> action) {
        this.customArrayList.forEach(action);
    }

    @Override
    public String toString() {
        return "RepositoryImpl " + customArrayList;
    }
}
