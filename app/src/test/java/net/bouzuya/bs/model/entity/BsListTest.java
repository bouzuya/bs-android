package net.bouzuya.bs.model.entity;

import org.junit.Test;
import org.threeten.bp.Instant;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BsListTest {
    @Test
    public void test() {
        Bs bs1 = Bs.of(Instant.now(), "note1");
        Bs bs2 = Bs.of(Instant.now(), "note2");
        BsList bsList = BsList.from(bs1, bs2);
        List<Bs> list = bsList.toList();
        assertThat(list.size(), is(2));
        assertThat(list.get(0), is(bs1));
        assertThat(list.get(1), is(bs2));
    }
}
