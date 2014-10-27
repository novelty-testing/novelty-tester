package fr.inria.diverse.noveltytesting.operator;

import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Population;
import fr.inria.diverse.noveltytesting.noveltyengine.NoveltyEngineImpl;

import java.util.List;

/**
 * Created by leiko on 24/10/14.
 */
public class SelectionOperator implements Operator {

    @Override
    public void process(Population population) {
    	int noveltyThreshold= 100; // should be in the common list parameters 
        List<Interface> interfaces = population.getInterfaces();

        interfaces.stream()
                .filter(anInterface -> anInterface.getFitness() > 1 || anInterface.getBehaviour().getNoveltyMetric()<100)
                .forEach(population::removeInterface);
        
        NoveltyEngineImpl.Archive.addInterfaces(interfaces);
    }
}
