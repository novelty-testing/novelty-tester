package fr.inria.diverse.noveltytesting.noveltyengine;

import fr.inria.diverse.noveltytesting.geneticoperators.SelectionOperator;
import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Method;
import fr.inria.diverse.noveltytesting.modelgeneration.ModelGeneration;
import fr.inria.diverse.noveltytesting.modelgeneration.ModelGenerationImpl;
import fr.inria.diverse.noveltytesting.population.population;
import fr.inria.diverse.noveltytesting.visitor.InputOutputVisitor;
import fr.inria.diverse.noveltytesting.visitor.Visitor;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mboussaa
 *
 */

public class NoveltyEngineImpl implements NoveltyEngine  {

    private population models;
    

    public void NoveltyEngineImpl() {
    	models = new population();
    }
    
	@Override
    public population generatePopulation() throws Exception {
		
		ModelGeneration model=new ModelGenerationImpl();
		
        Class clazz = Class.forName("fr.inria.diverse.noveltytesting.samples.FooClass");

        for (int numberSolutions = 0; numberSolutions < 10; numberSolutions++) {

        Interface i = model.generateModel(clazz);
        model.generateData(i);
        model.executeMethods(i);
        
        models.add(i);

    	}

       return models;
    }
    

	@Override
	public population generateNextPop(population models) {
		population pop = models;
		pop.SelectionOperator();
		pop.CrossoverOperator();
		pop.MutationOperator();

		 return pop;
	}



}