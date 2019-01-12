package com.denr.solidwaste.base;

import android.arch.lifecycle.ViewModel;


import com.denr.solidwaste.utils.rx.scheduler.RxScheduler;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel<N> extends ViewModel {

    private RxScheduler rxScheduler;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private N navigator;

    public BaseViewModel(RxScheduler rxScheduler) {
        this.rxScheduler = rxScheduler;
    }

    public BaseViewModel() {
    }

    @Override
    protected void onCleared() {
        compositeDisposable.dispose();
        super.onCleared();
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    public N getNavigator() {
        return navigator;
    }

    public void setNavigator(N navigator) {
        this.navigator = navigator;
    }

    public void setRxScheduler(RxScheduler rxScheduler) {
        this.rxScheduler = rxScheduler;
    }

    public RxScheduler getRxScheduler() {
        return rxScheduler;
    }
}
