package fr.inria.diverse.noveltytesting.geneticoperators;

import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Population;
import fr.inria.diverse.noveltytesting.noveltyengine.NoveltyEngineImpl;

import java.util.List;

/**
 * Created by leiko on 24/10/14.
 */
public class Selection implements Operator {

	@Override
	public void process(Population population) {
		int noveltyThreshold = 5; // should be in the common list parameters

		List<Interface> interfaces = population.getInterfaces();

		interfaces.stream()
				  .filter(anInterface -> anInterface.getBehaviour().getNoveltyMetric() < noveltyThreshold)
				  .forEach(population::removeInterface);

		NoveltyEngineImpl.relevantInterfaces.addInterfaces(population.getRelevantModels());
		NoveltyEngineImpl.Archive.addInterfaces(interfaces);
	}
}
