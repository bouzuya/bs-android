package net.bouzuya.bs.model.presenter;

import net.bouzuya.bs.model.repository.BsRepository;
import net.bouzuya.bs.model.repository.UserRepository;
import net.bouzuya.bs.model.view.BsView;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.mock;

public class BsPresenterFactoryTest {
    @Test
    public void testCreate() {
        BsRepository bsRepository = mock(BsRepository.class);
        UserRepository userRepository = mock(UserRepository.class);
        BsPresenterFactory bsPresenterFactory =
                new BsPresenterFactory(bsRepository, userRepository);
        BsView bsView = mock(BsView.class);
        BsPresenter bsPresenter = bsPresenterFactory.create(bsView);
        assertThat(bsPresenter, is(notNull()));
    }
}
