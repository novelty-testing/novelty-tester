package fr.inria.diverse.noveltytesting.model;

import fr.inria.diverse.noveltytesting.behaviour.Behaviour;
import fr.inria.diverse.noveltytesting.visitor.Visitable;
import fr.inria.diverse.noveltytesting.visitor.Visitor;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


/**
 * @author mboussaa
 *
 */
 
public class Population{

    private List<Interface> models;

    
    public Population() {
        this.models = new LinkedList<Interface>();
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
		List<Interface> listInterface = new LinkedList<Interface>();
	     for (Interface i : this.models) {
	           if (i.getFitness()<1) {
	        	   listInterface.add(i);
	                
	            }
	        }

	     return listInterface;
	    }

}
