package fr.inria.diverse.noveltytesting.geneticoperators;

import fr.inria.diverse.noveltytesting.behaviour.Behaviour;
import fr.inria.diverse.noveltytesting.behaviour.BehaviourImpl;
import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Population;
import fr.inria.diverse.noveltytesting.noveltyengine.NoveltyEngineImpl;

/**
 * The first step in calculating the novelty of a new individual is to measure
 * its behavioral distance to all other individuals in the population and to all
 * individuals in the archive, reflecting how different it is from current
 * behaviors (the current population) as well as behaviors that were novel in
 * the past (the archive).
 * 
 * To do so, we calculate the novelty metric (behaviour) and we assign it to
 * each interface of the population to handle the selection process
 * 
 * @author mboussaa
 *
 */

public class Evaluation implements Operator {
	Behaviour b = new BehaviourImpl();

	@Override
	public void process(Population population) {

		for (Interface i : population.getInterfaces()) {
			b.setNoveltyMetric(i, population, NoveltyEngineImpl.Archive);
			i.setBehaviour(b);
		}
	}

}
