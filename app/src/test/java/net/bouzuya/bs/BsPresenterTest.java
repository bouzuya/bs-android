package net.bouzuya.bs;

import org.junit.Test;
import org.threeten.bp.Instant;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BsPresenterTest {
    @Test
    public void testStart() {
        BsRepository bsRepository = mock(BsRepository.class);
        BsList bsList = BsList.from(Bs.of(Instant.now(), "note"));
        when(bsRepository.loadAll()).thenReturn(bsList);
        BsView bsView = mock(BsView.class);
        BsPresenter bsPresenter = new BsPresenter(bsRepository, bsView);
        bsPresenter.start();
        verify(bsRepository, times(1)).loadAll();
        verify(bsView, times(1)).showBsList(bsList);
    }
}
