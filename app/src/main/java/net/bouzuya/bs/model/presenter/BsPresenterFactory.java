package net.bouzuya.bs.model.presenter;

import net.bouzuya.bs.model.repository.BsRepository;
import net.bouzuya.bs.model.view.BsView;

public class BsPresenterFactory {
    private final BsRepository bsRepository;

    public BsPresenterFactory(BsRepository bsRepository) {
        this.bsRepository = bsRepository;
    }

    public BsPresenter create(BsView bsView) {
        return new BsPresenter(this.bsRepository, bsView);
    }
}
