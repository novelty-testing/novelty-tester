package fr.inria.diverse.noveltytesting.noveltyengine;

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
	public void updateBehaviour(Population models) {}

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
