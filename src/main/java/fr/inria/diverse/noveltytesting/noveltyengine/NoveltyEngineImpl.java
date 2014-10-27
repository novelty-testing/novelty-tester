package fr.inria.diverse.noveltytesting.noveltyengine;

import fr.inria.diverse.noveltytesting.behaviour.Behaviour;
import fr.inria.diverse.noveltytesting.behaviour.BehaviourImpl;
import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Population;
import fr.inria.diverse.noveltytesting.modelgeneration.ModelGeneration;
import fr.inria.diverse.noveltytesting.modelgeneration.ModelGenerationImpl;
import fr.inria.diverse.noveltytesting.operator.CrossoverOperator;
import fr.inria.diverse.noveltytesting.operator.MutationOperator;
import fr.inria.diverse.noveltytesting.operator.Operator;
import fr.inria.diverse.noveltytesting.operator.SelectionOperator;

import java.lang.reflect.InvocationTargetException;

/**
 * @author leiko
 *
 */

public class NoveltyEngineImpl implements NoveltyEngine  {

	private Operator selection = new SelectionOperator();
	private Operator mutation = new MutationOperator();
	private Operator crossover = new CrossoverOperator();

	/**
	 * kind of data base of visited/selected interfaces over all populations
	 * updated each selection process
	 */
	public static Population Archive = new Population();
	
	/**
	 * kind of data base of relevant interfaces over all populations
	 * updated each selection process
	 */
	public static Population relevantInterfaces = new Population();
	
	@Override
	public Population generatePopulation(String classFqn, int nb) throws Exception {
		ModelGeneration gen = new ModelGenerationImpl();
		Class<?> clazz = Class.forName(classFqn);

		Population population = new Population();

		for (int i = 0; i < nb; i++) {
			Interface anInterface = gen.generateModel(clazz);
			population.addInterface(anInterface);
		}

		return population;
	}

	@Override
	public void generateData(Population population) {
		ModelGeneration gen = new ModelGenerationImpl();
		population.getInterfaces().forEach(gen::generateData);
	}

	@Override
	public void updateBehaviour(Population population) {
		Behaviour b= new BehaviourImpl();
		for (Interface i : population.getInterfaces()) {
			b.setNoveltyMetric(i, population, Archive);
			i.setBehaviour(b);
		}
	}

	@Override
	public void executeMethods(Population population)
			throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
		ModelGeneration gen = new ModelGenerationImpl();
		for (Interface i : population.getInterfaces()) {
			gen.executeMethods(i);
		}
	}

	@Override
	public void process(Population population) {
		selection.process(population);
		mutation.process(population);
		crossover.process(population);
	}
}
