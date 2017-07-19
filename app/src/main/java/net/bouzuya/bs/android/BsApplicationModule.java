package net.bouzuya.bs.android;

import net.bouzuya.bs.model.entity.Bs;
import net.bouzuya.bs.model.entity.BsList;
import net.bouzuya.bs.model.entity.User;
import net.bouzuya.bs.model.presenter.BsPresenterFactory;
import net.bouzuya.bs.model.repository.BsRepository;

import org.threeten.bp.Duration;
import org.threeten.bp.Instant;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Single;

@Module
class BsApplicationModule {
    @Provides
    @Singleton
    BsRepository providesBsRepository() {
        return new BsRepository() {
            @Override
            public Single<BsList> loadAllOfUser(User user) {
                Bs bs1 = Bs.of(Instant.now(), "comment1");
                Bs bs2 = Bs.of(Instant.now().plus(Duration.ofSeconds(1)), "comment2comment2comment2comment2comment2comment2comment2comment2comment2comment2comment2comment2comment2comment2comment2comment2comment2comment2comment2comment2comment2comment2comment2comment2comment2comment2");
                BsList bsList = BsList.from(bs1, bs2);
                return Single.just(bsList);
            }
        };
    }

    @Provides
    @Singleton
    BsPresenterFactory providesBsPresenterFactory(BsRepository bsRepository) {
        return new BsPresenterFactory(bsRepository);
    }
}
