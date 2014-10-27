package fr.inria.diverse.noveltytesting.noveltyengine;

import fr.inria.diverse.noveltytesting.geneticoperators.Crossover;
import fr.inria.diverse.noveltytesting.geneticoperators.Evaluation;
import fr.inria.diverse.noveltytesting.geneticoperators.Mutation;
import fr.inria.diverse.noveltytesting.geneticoperators.Operator;
import fr.inria.diverse.noveltytesting.geneticoperators.Selection;
import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Population;
import fr.inria.diverse.noveltytesting.modelgeneration.ModelGeneration;
import fr.inria.diverse.noveltytesting.modelgeneration.ModelGenerationImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author leiko
 *
 */

public class NoveltyEngineImpl implements NoveltyEngine {

	private Operator selection;
	private Operator mutation;
	private Operator crossover;
	private Operator evaluation;

	ModelGeneration gen;

	private int popSize;
	private int archiveSize;
	private Class<?> clazz;

	/**
	 * kind of data base of visited/selected interfaces over all populations
	 * updated each selection process should have a fixed limit = 1000
	 */
	public static Population Archive;

	/**
	 * kind of data base of relevant interfaces over all populations updated
	 * each selection process
	 */
	public static Population relevantInterfaces;

	public NoveltyEngineImpl(String classFqn, int popSize, int archiveSize) throws ClassNotFoundException {

		this.clazz = Class.forName(classFqn);
		this.popSize = popSize;
		this.archiveSize = archiveSize;

		this.selection = new Selection();
		this.mutation = new Mutation();
		this.crossover = new Crossover();
		this.evaluation = new Evaluation();

		this.Archive = new Population(archiveSize);
		this.relevantInterfaces = new Population();

		this.gen = new ModelGenerationImpl();
	}

	@Override
	public Population generateInitialPopulation() {
		Population population = new Population();
		for (int i = 0; i < popSize; i++) {
			Interface anInterface = gen.generateModel(this.clazz);
			population.addInterface(anInterface);
		}
		population.setSize(popSize);
		population.getInterfaces().forEach(gen::generateData);

		return population;
	}

	@Override
	public void executeMethods(Population population) throws NoSuchMethodException, InstantiationException,
			IllegalAccessException, InvocationTargetException {

		ModelGeneration gen = new ModelGenerationImpl();
		for (Interface i : population.getInterfaces()) {
			gen.executeMethods(i);
		}
	}

	@Override
	public void ApplyGeneticOperators(Population population) {
		selection.process(population);
		mutation.process(population);
		crossover.process(population);
	}

	@Override
	public void EvaluateSolutions(Population population) {
		evaluation.process(population);

	}

	@Override
	public void generateNextPopulation(Population population) {
		List<Interface> newInterfaces = new ArrayList<>();
		for (int i = 0; i < population.getEmptyInterfaces(); i++) {
			Interface anInterface = gen.generateModel(clazz);
			newInterfaces.add(anInterface);
		}
		newInterfaces.forEach(gen::generateData);
		population.addInterfaces(newInterfaces);
	}

}
