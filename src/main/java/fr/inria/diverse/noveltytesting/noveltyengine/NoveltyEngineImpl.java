package fr.inria.diverse.noveltytesting.noveltyengine;

import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Population;
import fr.inria.diverse.noveltytesting.modelgeneration.ModelGeneration;
import fr.inria.diverse.noveltytesting.modelgeneration.ModelGenerationImpl;

/**
 * @author mboussaa
 *
 */

public class NoveltyEngineImpl implements NoveltyEngine  {

    private Population population;

    public void NoveltyEngineImpl() {
        population = new Population();
    }

    @Override
    public Population generatePopulation() throws Exception {

        ModelGeneration model=new ModelGenerationImpl();

        Class clazz = Class.forName("fr.inria.diverse.noveltytesting.samples.FooClass");

        for (int numberSolutions = 0; numberSolutions < 10; numberSolutions++) {
            Interface i = model.generateModel(clazz);
            model.generateData(i);
            model.executeMethods(i);
            population.add(i);
        }

        return population;
    }


    @Override
    public Population generateNextPop(Population models) {
        Population pop = models;
//        pop.SelectionOperator();
//        pop.CrossoverOperator();
//        pop.MutationOperator();

        return pop;
    }



}