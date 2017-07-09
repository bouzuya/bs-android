package net.bouzuya.bs;

import org.junit.Test;
import org.threeten.bp.Instant;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BsTest {
    @Test
    public void test() {
        Instant createdAt = Instant.parse("2006-01-02T22:04:05Z");
        Bs bs = Bs.of(createdAt, "note");
        assertThat(bs.getNote(), is("note"));
        assertThat(bs.getCreatedAt(), is(createdAt));
    }
}
