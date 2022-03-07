package org.chervyakovsky.customarray.observer;

import org.chervyakovsky.customarray.entity.CustomArray;

import java.util.EventObject;

public class CustomArrayEvent extends EventObject {

    public CustomArrayEvent(CustomArray source) {
        super(source);
    }

    public CustomArray getSource() {
        return (CustomArray) super.getSource();
    }
}
