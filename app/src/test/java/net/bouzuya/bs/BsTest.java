package net.bouzuya.bs;

import org.junit.Test;
import org.threeten.bp.Instant;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class BsTest {
    @Test
    public void test() {
        Instant createdAt = Instant.parse("2006-01-02T22:04:05Z");
        Bs bs = Bs.of(createdAt, "note");
        assertThat(bs.getContent(), is("note"));
        assertThat(bs.getCreatedAt(), is(createdAt));
    }

    @Test
    public void testEquals() {
        Instant createdAt = Instant.parse("2006-01-02T22:04:05Z");
        Bs bs1 = Bs.of(createdAt, "note");
        Bs bs2 = Bs.of(createdAt, "note");
        Bs bs3 = Bs.of(createdAt, "note2");
        assertThat(bs1, is(bs1));
        assertThat(bs1, is(bs2));
        assertThat(bs1, is(not(bs3)));
    }
}
