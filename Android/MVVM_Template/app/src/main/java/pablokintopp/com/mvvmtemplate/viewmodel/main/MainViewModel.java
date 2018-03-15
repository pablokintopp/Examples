package pablokintopp.com.mvvmtemplate.viewmodel.main;

import pablokintopp.com.mvvmtemplate.model.api.entity.Repo;
import pablokintopp.com.mvvmtemplate.util.RxBus;
import pablokintopp.com.mvvmtemplate.viewmodel.repolist.RepoClickEvent;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by mertsimsek on 13/01/17.
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

        subscription.add(rxBus.toObserverable()
                .filter(o -> o instanceof RepoClickEvent)
                .map(o -> (RepoClickEvent) o)
                .map(itemClickEvent -> itemClickEvent.repo)
                .subscribe(listener::onItemClicked));
    }

    public void stop() {
        if (subscription != null && !subscription.isUnsubscribed())
            subscription.unsubscribe();
    }

    public void setTwoPane(boolean isTwoPane) {
        this.isTwoPane = isTwoPane;
    }

    public boolean isTwoPane() {
        return isTwoPane;
    }

    public interface MainListener {
        void onItemClicked(Repo repo);
    }
}
