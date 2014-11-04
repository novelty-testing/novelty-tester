package fr.inria.diverse.noveltytesting.geneticoperators;

import fr.inria.diverse.noveltytesting.model.Population;

/**
 * Created by leiko on 04/11/14.
 */
public class Evaluation implements Operator {

    private Population archive;

    public Evaluation(Population archive) {
        this.archive = archive;
    }

    @Override
    public void process(Population population) {
        population.getInterfaces().forEach(i -> i.processNoveltyMetric(population, archive));
    }
}
