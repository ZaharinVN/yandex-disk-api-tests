package ru.qa.yandex.disk;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SimpleTest {

    @Test
    public void testOne() {
        assertTrue(true);
    }

    @Test
    public void testTwo() {
        assertThat(1 + 1, equalTo(2));
    }
}
