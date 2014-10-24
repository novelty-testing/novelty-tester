package fr.inria.diverse.noveltytesting;

import fr.inria.diverse.noveltytesting.model.Interface;
<<<<<<< HEAD
import fr.inria.diverse.noveltytesting.model.Method;
=======
>>>>>>> branch 'master' of https://github.com/novelty-testing/novelty-tester.git
import fr.inria.diverse.noveltytesting.modelgeneration.ModelGeneration;
import fr.inria.diverse.noveltytesting.modelgeneration.ModelGenerationImpl;
import fr.inria.diverse.noveltytesting.visitor.InputOutputVisitor;
import fr.inria.diverse.noveltytesting.visitor.Visitor;

import org.junit.Before;
import org.junit.Test;

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
<<<<<<< HEAD
       // novelty.addModel(i);
        
=======
>>>>>>> branch 'master' of https://github.com/novelty-testing/novelty-tester.git
        Visitor visitor = new InputOutputVisitor();
        i.accept(visitor);
<<<<<<< HEAD

    	}
        //novelty.generateNextPop();
        
        numberGenerations++;
        }


        //System.out.println("FITNESS "+i.fitness(i2));

=======
        System.out.println("FITNESS "+i.getFitness());
>>>>>>> branch 'master' of https://github.com/novelty-testing/novelty-tester.git
    }
}
