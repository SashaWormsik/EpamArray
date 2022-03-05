package org.chervyakovsky.customarray.entity;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {

    private static Warehouse instance;
    private final Map<Integer, CustomArrayParameter> parameter;

    private Warehouse() {
        this.parameter = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public boolean containsById(Integer id) {
        return this.parameter.containsKey(id);
    }

    public CustomArrayParameter getById(Integer id) {
        return this.parameter.get(id);
    }

    public CustomArrayParameter put(Integer id, CustomArrayParameter value) {
        return this.parameter.put(id, value);
    }

    public void putAll(Map<Integer, CustomArrayParameter> parameters) {
        this.parameter.putAll(parameters);
    }

    public CustomArrayParameter removeById(Integer id) {
        return this.parameter.remove(id);
    }

    public void clear() {
        this.parameter.clear();
    }

    @Override
    public String toString() {
        return "Warehouse " + parameter;
    }
}
