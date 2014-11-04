package fr.inria.diverse.noveltytesting.noveltyengine;

import fr.inria.diverse.noveltytesting.geneticoperators.*;
import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Population;
import fr.inria.diverse.noveltytesting.modelgeneration.ModelGenerator;
import fr.inria.diverse.noveltytesting.modelgeneration.ModelGeneratorImpl;

import java.lang.reflect.InvocationTargetException;

/**
 * @author leiko
 *
 */

public class NoveltyEngineImpl implements NoveltyEngine  {

    private ModelGenerator gen;
    private Operator selection;
    private Operator mutation;
    private Operator crossover;
    private Operator evaluation;
    private Population archive;

    public NoveltyEngineImpl() {
        this.gen = new ModelGeneratorImpl();
        this.archive = new Population();
        this.selection = new Selection(archive);
        this.mutation = new Mutation();
        this.crossover = new Crossover();
        this.evaluation = new Evaluation(archive);
    }

    @Override
    public void setExclusionPattern(String pattern) {
        this.gen.setExclusionPattern(pattern);
    }

    @Override
    public Population getArchive() {
        return archive;
    }

    @Override
    public Population generatePopulation(String classFqn, int nb) throws Exception {
        Class clazz = Class.forName(classFqn);

        Population population = new Population();

        for (int i = 0; i < nb; i++) {
            Interface anInterface = gen.generateModel(clazz);
            population.addInterface(anInterface);
        }

        return population;
    }

    @Override
    public void generateData(Population population) {
        ModelGenerator gen = new ModelGeneratorImpl();
        population.getInterfaces().forEach(gen::generateData);
    }

    @Override
    public void executeMethods(Population population)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        for (Interface i : population.getInterfaces()) {
            gen.executeMethods(i);
        }
    }

    @Override
    public void geneticProcess(Population population) {
        selection.process(population);
        mutation.process(population);
        crossover.process(population);
    }

    @Override
    public void evaluate(Population population) {
        evaluation.process(population);
    }
}