package fr.inria.diverse.noveltytesting.behaviour;

import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Population;

/**
 * Created by leiko on 16/10/14.
 */

public interface Behaviour {

	void setNoveltyMetric(Interface anInterface, Population population, Population archive);
	double getNoveltyMetric();


}
