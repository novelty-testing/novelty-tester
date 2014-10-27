package fr.inria.diverse.noveltytesting.geneticoperators;

import fr.inria.diverse.noveltytesting.behaviour.Behaviour;
import fr.inria.diverse.noveltytesting.behaviour.BehaviourImpl;
import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Population;
import fr.inria.diverse.noveltytesting.noveltyengine.NoveltyEngineImpl;

/**
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
