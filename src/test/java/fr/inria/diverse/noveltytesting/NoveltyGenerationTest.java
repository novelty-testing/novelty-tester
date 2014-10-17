package fr.inria.diverse.noveltytesting;

import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Method;
import fr.inria.diverse.noveltytesting.visitor.InputOutputVisitor;
import fr.inria.diverse.noveltytesting.visitor.Visitor;
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
    public void testTestClass() throws Exception {
        Class clazz = Class.forName("fr.inria.diverse.noveltytesting.samples.FooClass");
        Interface i = novelty.generateModel(clazz);
        novelty.generateData(i);
        novelty.executeMethods(i);

        Interface i2 = novelty.generateModel(clazz);
        novelty.generateData(i2);
        novelty.executeMethods(i2);

        Visitor visitor = new InputOutputVisitor();

        i.accept(visitor);
        i2.accept(visitor);

        System.out.println("FITNESS "+i.fitness(i2));

    }
}