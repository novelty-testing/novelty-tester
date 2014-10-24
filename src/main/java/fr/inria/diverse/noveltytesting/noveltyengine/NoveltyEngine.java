package fr.inria.diverse.noveltytesting.noveltyengine;

import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Method;
import fr.inria.diverse.noveltytesting.model.Population;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

/**
 * This class runs the methods of the given Interface model using the generated
 * data for the different parameters
 *
 * Created by leiko on 17/10/14.
 */
public interface NoveltyEngine{
	
	void generatePopulation() throws Exception;

	void generateNextPop(Population models);

	void updateBehaviour(Population models);
	

   
}
