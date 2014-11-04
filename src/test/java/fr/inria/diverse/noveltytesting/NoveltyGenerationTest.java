package fr.inria.diverse.noveltytesting;

import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Population;
import fr.inria.diverse.noveltytesting.noveltyengine.NoveltyEngine;
import fr.inria.diverse.noveltytesting.noveltyengine.NoveltyEngineImpl;
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
	private int archiveSize;
	private int numberGenerations;

	@Before
	public void testBefore() {
		this.clazz = "fr.inria.diverse.noveltytesting.samples.FooClass";
		this.popSize = 2;
		this.archiveSize = 1000;
		this.numberGenerations = 2;
	}

	@Test
	public void testTestClass() throws Exception {
		NoveltyEngine engine = new NoveltyEngineImpl(clazz, popSize,
				archiveSize);

		// first population
		Population population = engine.generateInitialPopulation();

		// next populations
		for (int i = 0; i < numberGenerations; i++) {

			engine.executeMethods(population);
			engine.evaluateSolutions(population);
			engine.displayPopulation(population);
			engine.applyGeneticOperators(population);
			engine.generateNextPopulation(population);

		}

	}
}