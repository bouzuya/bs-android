package net.bouzuya.bs.model.entity;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class UserTest {
    @Test
    public void test() {
        User user = User.of("123");
        assertThat(user.getId(), is("123"));
    }

    @Test
    public void testConstructorValidation() {
        try {
            User.of(null);
            Assert.fail();
        } catch (IllegalArgumentException e) {
            assertThat(e, is(not(nullValue())));
        }
    }

    @Test
    public void testEquals() {
        User u1 = User.of("123");
        User u2 = User.of("123");
        User u3 = User.of("456");
        assertThat(u1, is(u1));
        assertThat(u1, is(u2));
        assertThat(u1, is(not(u3)));
    }
}
