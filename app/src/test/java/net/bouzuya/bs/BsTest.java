package net.bouzuya.bs;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BsTest {
    @Test
    public void test() {
        Bs bs = Bs.of("2006-01-02T15:04:05-07:00", "note");
        assertThat(bs.getNote(), is("note"));
        assertThat(bs.getCreatedAt(), is("2006-01-02T15:04:05-07:00"));
    }
}
