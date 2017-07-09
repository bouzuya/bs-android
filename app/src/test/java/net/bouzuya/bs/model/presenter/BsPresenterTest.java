package net.bouzuya.bs.model.presenter;

import net.bouzuya.bs.model.entity.Bs;
import net.bouzuya.bs.model.entity.BsList;
import net.bouzuya.bs.model.repository.BsRepository;
import net.bouzuya.bs.model.view.BsView;

import org.junit.Test;
import org.threeten.bp.Instant;

import io.reactivex.Single;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BsPresenterTest {
    @Test
    public void testStartFailure() {
        BsRepository bsRepository = mock(BsRepository.class);
        Exception exception = new Exception();
        when(bsRepository.loadAll()).thenReturn(Single.<BsList>error(exception));
        BsView bsView = mock(BsView.class);
        BsPresenter bsPresenter = new BsPresenter(bsRepository, bsView);
        bsPresenter.start();
        verify(bsRepository, times(1)).loadAll();
        verify(bsView, times(0)).showBsList(any(BsList.class));
        verify(bsView, times(1)).showLoadException(exception);
    }

    @Test
    public void testStartSuccess() {
        BsRepository bsRepository = mock(BsRepository.class);
        BsList bsList = BsList.from(Bs.of(Instant.now(), "note"));
        when(bsRepository.loadAll()).thenReturn(Single.just(bsList));
        BsView bsView = mock(BsView.class);
        BsPresenter bsPresenter = new BsPresenter(bsRepository, bsView);
        bsPresenter.start();
        verify(bsRepository, times(1)).loadAll();
        verify(bsView, times(1)).showBsList(bsList);
        verify(bsView, times(0)).showLoadException(any(Exception.class));
    }
}
