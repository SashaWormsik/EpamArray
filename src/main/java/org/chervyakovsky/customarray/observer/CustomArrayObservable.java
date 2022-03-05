package org.chervyakovsky.customarray.observer;

public interface CustomArrayObservable {

    void attach(CustomArrayObserver observer);

    void detach();

    void notifyObserver();
}
