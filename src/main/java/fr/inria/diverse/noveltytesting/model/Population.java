package fr.inria.diverse.noveltytesting.model;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author mboussaa
 *
 */
 
public class Population extends LinkedList<Interface> {

	public List<Interface> getRelevantModels() {
        return this.stream()
                .filter(i -> i.getFitness() < 1)
                .collect(Collectors.toCollection(LinkedList::new));
	    }
}
