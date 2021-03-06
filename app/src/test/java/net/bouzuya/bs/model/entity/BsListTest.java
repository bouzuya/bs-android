package net.bouzuya.bs.model.entity;

import org.junit.Test;
import org.threeten.bp.Instant;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BsListTest {
    @Test
    public void testEmpty() {
        BsList bsList = BsList.empty();
        assertThat(bsList.size(), is(0));
    }

    @Test
    public void testFrom() {
        Bs bs1 = Bs.of(Instant.now(), "note1");
        Bs bs2 = Bs.of(Instant.now(), "note2");
        BsList bsList = BsList.from(bs1, bs2);
        assertThat(bsList.size(), is(2));
        assertThat(bsList.get(0), is(bs1));
        assertThat(bsList.get(1), is(bs2));
    }
}
