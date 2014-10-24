package fr.inria.diverse.noveltytesting.operator;

import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Population;

import java.util.List;

/**
 * Created by leiko on 24/10/14.
 */
public class SelectionOperator implements Operator {

    @Override
    public void process(Population population) {
        List<Interface> interfaces = population.getInterfaces();

        interfaces.stream()
                .filter(anInterface -> anInterface.getFitness() > 1)
                .forEach(population::removeInterface);
    }
}
