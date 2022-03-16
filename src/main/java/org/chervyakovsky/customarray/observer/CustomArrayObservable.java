package org.chervyakovsky.customarray.observer;

public interface CustomArrayObservable {

    void attach(CustomArrayObserver observers);

    void detach();

    void notifyObservers();
}
