package fr.inria.diverse.noveltytesting;

import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Method;
import fr.inria.diverse.noveltytesting.modelgeneration.ModelGeneration;
import fr.inria.diverse.noveltytesting.modelgeneration.ModelGenerationImpl;
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

    private ModelGeneration novelty;

    @Before
    public void testBefore() {
        novelty = new ModelGenerationImpl();
    }

    @Test
    public void testTestClass() throws Exception {
        Class clazz = Class.forName("fr.inria.diverse.noveltytesting.samples.FooClass");
        
        
        int numberGenerations = 0;
        while (numberGenerations<10) {
	
        for (int numberSolutions = 0; numberSolutions < 10; numberSolutions++) {
			
	
        Interface i = novelty.generateModel(clazz);
        novelty.generateData(i);
        novelty.executeMethods(i);
       // novelty.addModel(i);
        
        Visitor visitor = new InputOutputVisitor();

        i.accept(visitor);

    	}
        //novelty.generateNextPop();
        
        numberGenerations++;
        }


        //System.out.println("FITNESS "+i.fitness(i2));

    }
}