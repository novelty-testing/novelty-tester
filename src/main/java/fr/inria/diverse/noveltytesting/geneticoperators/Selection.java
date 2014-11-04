package fr.inria.diverse.noveltytesting.geneticoperators;

import fr.inria.diverse.noveltytesting.model.Population;

/**
 * Created by leiko on 24/10/14.
 */
public class Selection implements Operator {

    private double threshold;
    private Population archive;

    public Selection(Population archive) {
        this.threshold = 0;
        this.archive = archive;
    }

    public void setThreshold(double d) {
        this.threshold = d;
    }

	@Override
	public void process(Population population) {
        population.getInterfaces().forEach(i -> {
            if (i.getNoveltyMetric() < threshold) {
                population.removeInterface(i);
            }
        });

        archive.addInterfaces(population.getInterfaces());
	}
}
