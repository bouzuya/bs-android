package net.bouzuya.bs.model.presenter;

import net.bouzuya.bs.model.entity.BsList;
import net.bouzuya.bs.model.repository.BsRepository;
import net.bouzuya.bs.model.view.BsView;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

class BsPresenter {
    private final BsRepository bsRepository;
    private final BsView bsView;

    BsPresenter(BsRepository bsRepository, BsView bsView) {
        this.bsRepository = bsRepository;
        this.bsView = bsView;
    }

    void start() {
        this.bsRepository.loadAll().subscribe(new Consumer<BsList>() {
            @Override
            public void accept(@NonNull BsList bsList) throws Exception {
                BsPresenter.this.bsView.showBsList(bsList);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                BsPresenter.this.bsView.showLoadException(throwable);
            }
        });
    }
}
