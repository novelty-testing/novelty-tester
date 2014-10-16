package fr.inria.diverse.noveltytesting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test
 */
public class JavaTestCase {

    private NoveltyGeneration novelty;

    @Before
    public void testBefore() {
        novelty = new NoveltyGeneration();
    }

    @Test
    public void testSomeMethod() {
        assertEquals("foo", "foo");
    }

    @Test
    public void testSomeMethod2() {
        assertNotEquals("bar", "baz");
    }
}
