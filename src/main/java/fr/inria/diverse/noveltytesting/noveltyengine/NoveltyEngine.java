package fr.inria.diverse.noveltytesting.noveltyengine;

import fr.inria.diverse.noveltytesting.model.Population;

import java.lang.reflect.InvocationTargetException;

/**
 *
 * Created by leiko on 17/10/14.
 */
public interface NoveltyEngine {

	Population generateInitialPopulation();

	void executeMethods(Population population) throws NoSuchMethodException,InstantiationException, IllegalAccessException, InvocationTargetException;

	void generateNextPopulation(Population population);

	void ApplyGeneticOperators(Population population);

	void EvaluateSolutions(Population population);
	
	void displayPopulation(Population population);
}
