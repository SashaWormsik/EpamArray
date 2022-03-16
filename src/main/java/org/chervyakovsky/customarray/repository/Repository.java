package org.chervyakovsky.customarray.repository;

import org.chervyakovsky.customarray.entity.CustomArray;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public interface Repository {

    boolean add(CustomArray customArray);

    boolean addAll(Collection<CustomArray> collectionCustomArray);

    boolean remove(CustomArray customArray);

    boolean removeAll(Collection<CustomArray> collectionCustomArray);

    CustomArray get(int index);

    List<CustomArray> getAll();

    CustomArray set(int index, CustomArray customArray);

    List<CustomArray> query(Specification specification);

    List<CustomArray> sort(Comparator<CustomArray> comparator);

    void forEach(Consumer<? super CustomArray> action);
}
