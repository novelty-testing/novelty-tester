package fr.inria.diverse.noveltytesting.geneticoperators;

import fr.inria.diverse.noveltytesting.generator.Generator;
import fr.inria.diverse.noveltytesting.generator.RandomMutationGenerator;
import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Population;

import java.util.List;

/**
 * Created by leiko on 24/10/14.
 */
public class Mutation implements Operator {
	private Generator mutationGenerator = new RandomMutationGenerator();

	@Override
	public void process(Population population) {
		List<Interface> interfaces = population.getInterfaces();

		for (Interface anInterface : interfaces) {
			anInterface.getMethods().forEach(this.mutationGenerator::generateData);
		}
	}
}
