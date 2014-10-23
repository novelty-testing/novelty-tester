package fr.inria.diverse.noveltytesting.model;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author mboussaa
 *
 */
 
public class Population {

    private List<Interface> models;

    
    public Population() {
        this.models = new LinkedList<>();
    }

    public List<Interface> getModels() {
		return models;
	}

	public void setModels(List<Interface> models) {
		this.models = models;
	}


    public Interface get(int index) {
		return models.get(index);
	}

	public boolean add(Interface e) {
		return models.add(e);
	}


	public Interface set(int index, Interface element) {
		return models.set(index, element);
	}

	public void add(int index, Interface element) {
		models.add(index, element);
	}


	public List<Interface> getRelevantModels() {
        return this.models.stream()
                .filter(i -> i.getFitness() < 1)
                .collect(Collectors.toCollection(LinkedList::new));
	    }

}
