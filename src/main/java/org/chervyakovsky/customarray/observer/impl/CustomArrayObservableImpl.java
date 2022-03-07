package org.chervyakovsky.customarray.observer.impl;

import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.observer.CustomArrayEvent;
import org.chervyakovsky.customarray.observer.CustomArrayObservable;
import org.chervyakovsky.customarray.observer.CustomArrayObserver;

public abstract class CustomArrayObservableImpl implements CustomArrayObservable {

    private CustomArrayObserver observers;

    @Override
    public void attach(CustomArrayObserver observers) {
        this.observers = observers;
    }

    @Override
    public void detach() {
        this.observers = null;
    }

    @Override
    public void notifyObservers() {
        CustomArrayEvent event = new CustomArrayEvent((CustomArray) this);
        if (observers != null) {
            observers.updateCustomArrayParameter(event);
        }
    }
}
