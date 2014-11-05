package fr.inria.diverse.noveltytesting;

import fr.inria.diverse.noveltytesting.model.Population;
import fr.inria.diverse.noveltytesting.noveltyengine.NoveltyEngine;
import fr.inria.diverse.noveltytesting.noveltyengine.NoveltyEngineImpl;

import fr.inria.diverse.noveltytesting.visitor.FileOutputVisitor;
import fr.inria.diverse.noveltytesting.visitor.InputOutputVisitor;
import fr.inria.diverse.noveltytesting.visitor.Visitor;
import org.junit.Before;
import org.junit.Test;

/**
 * each client instantiates the engine by giving as a parameter the services'
 * interface, the pop and the archive size and then apply the different services
 * of the novelty algorithm
 * 
 * Unit test
 */
public class NoveltyGenerationTest {

	private String clazz;
	private int popSize;
	private int numberGenerations;

	@Before
	public void testBefore() {
		this.clazz = "fr.inria.diverse.noveltytesting.samples.FunctionsImpl";
		this.popSize = 2;
		this.numberGenerations = 2;
	}

	@Test
	public void testTestClass() throws Exception {
		NoveltyEngine engine = new NoveltyEngineImpl();
        engine.setExclusionPattern("__hx_");
        Population pop = engine.generatePopulation(this.clazz, this.popSize);
        engine.generateData(pop);


        Visitor visitor = new InputOutputVisitor();
        for (int i=0; i < this.numberGenerations; i++) {
            engine.executeMethods(pop);
            pop.accept(visitor);
            engine.evaluate(pop);
            engine.geneticProcess(pop);
            pop.accept(visitor);
            engine.generateData(pop);
        }
	}
}
