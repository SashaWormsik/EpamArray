package org.chervyakovsky.customarray.observer.impl;

import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.observer.CustomArrayEvent;
import org.chervyakovsky.customarray.observer.CustomArrayObservable;
import org.chervyakovsky.customarray.observer.CustomArrayObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class CustomArrayObservableImpl implements CustomArrayObservable {

    private CustomArrayObserver observer;

    @Override
    public void attach(CustomArrayObserver observer) {
        this.observer = observer;
    }

    @Override
    public void detach() {
        this.observer = null;
    }

    @Override
    public void notifyObserver() {
        CustomArrayEvent event = new CustomArrayEvent((CustomArray) this);
        if (observer != null) {
            observer.updateCustomArrayParameter(event);
        }
    }
}
