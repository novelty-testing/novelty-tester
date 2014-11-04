package fr.inria.diverse.noveltytesting.behaviour;

import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Parameter;
import fr.inria.diverse.noveltytesting.model.Population;

/**
 * Created by leiko on 16/10/14.
 */

public interface Behaviour {

	void setNoveltyMetric(Interface anInterface, Population population, Population archive);
	double getNoveltyMetric();
	double distanceParameters(Parameter parameter1, Parameter parameter2);

}
