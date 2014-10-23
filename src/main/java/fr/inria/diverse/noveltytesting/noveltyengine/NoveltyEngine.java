package fr.inria.diverse.noveltytesting.noveltyengine;

import fr.inria.diverse.noveltytesting.model.Population;

/**
 * This class runs the methods of the given Interface model using the generated
 * data for the different parameters
 *
 * Created by leiko on 17/10/14.
 */
public interface NoveltyEngine {
	
	Population generatePopulation() throws Exception;

    Population generateNextPop(Population models);
}
