package net.bouzuya.bs;

import java.util.List;

class BsPresenter {
    private final BsRepository bsRepository;
    private final BsView bsView;

    public BsPresenter(BsRepository bsRepository, BsView bsView) {
        this.bsRepository = bsRepository;
        this.bsView = bsView;
    }

    void start() {
        List<Bs> bsList = this.bsRepository.loadAll();
        this.bsView.showBsList(bsList);
    }
}
