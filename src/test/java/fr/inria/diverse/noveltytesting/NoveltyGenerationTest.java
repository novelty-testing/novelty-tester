package fr.inria.diverse.noveltytesting;

import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Method;
import fr.inria.diverse.noveltytesting.visitor.InputOutputVisitor;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test
 */
public class NoveltyGenerationTest {

    private NoveltyGeneration novelty;

    @Before
    public void testBefore() {
        novelty = new NoveltyGenerationImpl();
    }

    @Test
    public void testTestClass() {
        try {
            Interface i = novelty.generateModel(Class.forName("fr.inria.diverse.noveltytesting.samples.FooClass"));
            novelty.generateData(i);
            novelty.executeMethods(i);

            new InputOutputVisitor().visit(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}