package fr.inria.diverse.noveltytesting.geneticoperators;

import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Population;

import java.util.List;

/**
 * Created by leiko on 24/10/14.
 */
public class Crossover implements Operator {

	@Override
	public void process(Population population) {
		int crossoverPoint = 0;
		int crossoverMethodPosition = 0;
		Object permute = null;

		List<Interface> interfaces = population.getInterfaces();
		if (interfaces.size() > 1) {
			for (int i = 0; i < interfaces.size() - 1; i++) {

				crossoverMethodPosition = (int) (Math.random() * interfaces.get(i).getMethods().size());
				crossoverPoint = (int) (Math.random() * interfaces.get(i).getMethods().get(crossoverMethodPosition).getParameters().size());

				permute = interfaces.get(i).getMethods().get(crossoverMethodPosition).getParameters().get(crossoverPoint).getValue();
				
				interfaces
						.get(i)
						.getMethods()
						.get(crossoverMethodPosition)
						.getParameters()
						.get(crossoverPoint)
						.setValue(
								interfaces.get(i + 1).getMethods()
										.get(crossoverMethodPosition)
										.getParameters().get(crossoverPoint)
										.getValue());
				
				interfaces.get(i + 1).getMethods().get(crossoverMethodPosition).getParameters().get(crossoverPoint).setValue(permute);
			}

		}

	}
}
