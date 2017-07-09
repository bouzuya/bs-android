package net.bouzuya.bs;

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
