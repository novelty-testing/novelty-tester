package fr.inria.diverse.noveltytesting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Unit test
 */
public class JavascriptTestCase {

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
