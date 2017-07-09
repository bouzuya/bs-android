package net.bouzuya.bs.android;

import net.bouzuya.bs.model.entity.Bs;
import net.bouzuya.bs.model.entity.BsList;
import net.bouzuya.bs.model.presenter.BsPresenterFactory;
import net.bouzuya.bs.model.repository.BsRepository;

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
            public Single<BsList> loadAll() {
                return Single.just(BsList.from(Bs.of(Instant.now(), "content")));
            }
        };
    }

    @Provides
    @Singleton
    BsPresenterFactory providesBsPresenterFactory(BsRepository bsRepository) {
        return new BsPresenterFactory(bsRepository);
    }
}
