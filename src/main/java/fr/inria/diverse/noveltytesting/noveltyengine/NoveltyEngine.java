package fr.inria.diverse.noveltytesting.noveltyengine;

import fr.inria.diverse.noveltytesting.model.Population;

import java.lang.reflect.InvocationTargetException;

/**
 *
 * Created by leiko on 17/10/14.
 */
public interface NoveltyEngine {

	Population generatePopulation(String classFqn, int nb) throws Exception;

	void updateBehaviour(Population population);

    void generateData(Population population);

    void executeMethods(Population population)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;

    void process(Population population);
}
