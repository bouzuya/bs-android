package net.bouzuya.bs.model.presenter;

import net.bouzuya.bs.model.entity.BsList;
import net.bouzuya.bs.model.repository.BsRepository;
import net.bouzuya.bs.model.view.BsView;

class BsPresenter {
    private final BsRepository bsRepository;
    private final BsView bsView;

    public BsPresenter(BsRepository bsRepository, BsView bsView) {
        this.bsRepository = bsRepository;
        this.bsView = bsView;
    }

    void start() {
        BsList bsList = this.bsRepository.loadAll();
        this.bsView.showBsList(bsList);
    }
}
