package net.bouzuya.bs.model.presenter;

import net.bouzuya.bs.model.repository.BsRepository;
import net.bouzuya.bs.model.repository.UserRepository;
import net.bouzuya.bs.model.view.BsView;

public class BsPresenterFactory {
    private final BsRepository bsRepository;
    private final UserRepository userRepository;

    public BsPresenterFactory(BsRepository bsRepository, UserRepository userRepository) {
        this.bsRepository = bsRepository;
        this.userRepository = userRepository;
    }

    public BsPresenter create(BsView bsView) {
        return new BsPresenter(this.bsRepository, bsView, this.userRepository);
    }
}
