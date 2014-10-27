package fr.inria.diverse.noveltytesting;

import fr.inria.diverse.noveltytesting.model.Population;
import fr.inria.diverse.noveltytesting.noveltyengine.NoveltyEngine;
import fr.inria.diverse.noveltytesting.noveltyengine.NoveltyEngineImpl;

import org.junit.Before;
import org.junit.Test;

/**
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
		this.popSize = 100;
		this.archiveSize = 1000;
		this.numberGenerations = 10;
	}

	@Test
	public void testTestClass() throws Exception {
		NoveltyEngine engine = new NoveltyEngineImpl(clazz, popSize, archiveSize);
		
		//first population
		Population population = engine.generateInitialPopulation();
		engine.executeMethods(population);
		engine.EvaluateSolutions(population);

		//next populations
		for (int i = 0; i < numberGenerations; i++) {
			
			engine.executeMethods(population);
			engine.EvaluateSolutions(population);
			engine.ApplyGeneticOperators(population);
			engine.generateNextPopulation(population);

		}
	}
}
