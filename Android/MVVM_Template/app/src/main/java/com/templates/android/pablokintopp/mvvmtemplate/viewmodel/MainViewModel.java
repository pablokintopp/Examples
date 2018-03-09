package com.templates.android.pablokintopp.mvvmtemplate.viewmodel;

import com.templates.android.pablokintopp.mvvmtemplate.model.entity.Movie;
import com.templates.android.pablokintopp.mvvmtemplate.util.RxBus;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by Pablo on 07/03/2018.
 */

public class MainViewModel {

    private RxBus rxBus;
    private MainListener listener;
    private boolean isTwoPane = false;
    private CompositeSubscription subscription;

    public MainViewModel(RxBus rxBus, MainListener listener) {
        this.rxBus = rxBus;
        this.listener = listener;
        subscription = new CompositeSubscription();

        subscription.add(rxBus.toObservable()
                .filter(o -> o instanceof MovieClickEvent)
                .map(o -> (MovieClickEvent) o)
                .map(movieClickEvent -> movieClickEvent.movie)
                .subscribe(listener::onMovieItemClicked));
    }

    public void stop(){
        if(subscription != null && !subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
    }

    public void setTwoPane(boolean isTwoPane){
        this.isTwoPane = isTwoPane;
    }

    public boolean isTwoPane(){
        return isTwoPane;
    }

    public interface MainListener{
        void onMovieItemClicked(Movie movie);
    }
}
