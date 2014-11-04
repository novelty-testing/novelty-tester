package fr.inria.diverse.noveltytesting.geneticoperators;

import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Population;
import fr.inria.diverse.noveltytesting.noveltyengine.NoveltyEngineImpl;

import java.util.List;

/**
 * for each population we use the selection operator to select interfaces that
 * have a novelty metric < a threshold and then we remove the remaining
 * interfaces
 * 
 * we use to save for each selection process the interfaces with a fitness value
 * below 1 in order to display at the end of the algorithm the list of
 * interfaces that have generated anomalies or incoherence in the outputs.
 * 
 * as well, we save the selected interfaces in a shared population called
 * Archive. In fact, the archive remembers past individuals that were highly
 * novel when they were first discovered (originated).
 * 
 * This is useful to calculate the novelty metric of each interface in the next
 * populations (see evaluation doc for more information about the novelty
 * metric)
 * 
 * 
 * Created by leiko on 24/10/14.
 */
public class Selection implements Operator {

	@Override
	public void process(Population population) {
		int noveltyThreshold = 0; // should be in the common list parameters

		List<Interface> interfaces = population.getInterfaces();

		interfaces
				.stream()
				.filter(anInterface -> anInterface.getBehaviour()
						.getNoveltyMetric() < noveltyThreshold)
				.forEach(population::removeInterface);

		NoveltyEngineImpl.relevantInterfaces.addInterfaces(population
				.getRelevantModels());
		NoveltyEngineImpl.Archive.addInterfaces(interfaces);
	}
}
