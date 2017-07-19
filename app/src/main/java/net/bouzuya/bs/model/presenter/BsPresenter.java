package net.bouzuya.bs.model.presenter;

import net.bouzuya.bs.model.entity.BsList;
import net.bouzuya.bs.model.entity.User;
import net.bouzuya.bs.model.repository.BsRepository;
import net.bouzuya.bs.model.repository.UserRepository;
import net.bouzuya.bs.model.view.BsView;

import io.reactivex.SingleSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class BsPresenter {
    private final BsRepository bsRepository;
    private final BsView bsView;
    private final UserRepository userRepository;

    BsPresenter(BsRepository bsRepository, BsView bsView, UserRepository userRepository) {
        this.bsRepository = bsRepository;
        this.bsView = bsView;
        this.userRepository = userRepository;
    }

    public void start() {
        this.userRepository.loadOrCreate().flatMap(new Function<User, SingleSource<BsList>>() {
            @Override
            public SingleSource<BsList> apply(User user) throws Exception {
                return BsPresenter.this.bsRepository.loadAllOfUser(user);
            }
        }).subscribe(new Consumer<BsList>() {
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
