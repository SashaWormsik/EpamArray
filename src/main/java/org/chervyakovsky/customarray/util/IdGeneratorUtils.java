package org.chervyakovsky.customarray.util;

public class IdGeneratorUtils {

    private static int presentId = 0;

    public static int generateId() {
        return presentId++;
    }
}
