package fr.inria.diverse.noveltytesting.noveltyengine;

import fr.inria.diverse.noveltytesting.geneticoperators.GeneticOperators;
import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Method;
import fr.inria.diverse.noveltytesting.model.Population;
import fr.inria.diverse.noveltytesting.modelgeneration.ModelGeneration;
import fr.inria.diverse.noveltytesting.modelgeneration.ModelGenerationImpl;
import fr.inria.diverse.noveltytesting.visitor.InputOutputVisitor;
import fr.inria.diverse.noveltytesting.visitor.Visitor;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.LinkedList;


/**
 * @author mboussaa
 *
 */

public class NoveltyEngineImpl implements NoveltyEngine  {

    private Population models;

    public void NoveltyEngineImpl() {
    	models = new Population();
    }
    
	@Override
    public void generatePopulation() throws Exception {
		
		ModelGeneration model=new ModelGenerationImpl();
		
        Class clazz = Class.forName("fr.inria.diverse.noveltytesting.samples.FooClass");

        for (int numberSolutions = 0; numberSolutions < 10; numberSolutions++) {

        Interface i = model.generateModel(clazz);
        model.generateData(i);
        model.executeMethods(i);
        
        models.add(i);

    	}
    }
    
	@Override
	public void updateBehaviour(Population models) {
		

	}

	@Override
	public void generateNextPop(Population models) {
		GeneticOperators operators = new GeneticOperators();
		operators.selectionData(models);
		operators.crossoverData(models);
		operators.mutationData(models);

	}



}