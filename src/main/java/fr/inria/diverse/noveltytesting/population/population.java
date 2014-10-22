package fr.inria.diverse.noveltytesting.population;

import fr.inria.diverse.noveltytesting.behaviour.Behaviour;
import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.visitor.Visitable;
import fr.inria.diverse.noveltytesting.visitor.Visitor;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


/**
 * @author mboussaa
 *
 */

public class population implements Visitable {

    private List<Interface> models;

    
    public population() {
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


    @Override
    public void accept(Visitor visitor, boolean visitChildren, boolean isRecursive) {
        visitor.visit(this);
        if (visitChildren) {
            if (isRecursive) {
                models.forEach(m -> m.accept(visitor, true, true));
            } else {
            	models.forEach(m -> m.accept(visitor, false, false));
            }
        }
    }

    @Override
    public void accept(Visitor visitor) {
        this.accept(visitor, true, true);
    }

}
