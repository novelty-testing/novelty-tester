package fr.inria.diverse.noveltytesting.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author leiko
 *
 */
 
public class Population {

    private List<Interface> interfaces;

    public Population() {
        this.interfaces = new ArrayList<>();
    }

    public List<Interface> getInterfaces() {
        return interfaces;
    }

    public void addInterfaces(List<Interface> interfaces) {
        this.interfaces.addAll(interfaces);
    }

    public void addInterface(Interface i) {
        this.interfaces.add(i);
    }

    public List<Interface> getRelevantModels() {
        return this.interfaces.stream()
                .filter(i -> i.getFitness() < 1)
                .collect(Collectors.toCollection(LinkedList::new));
	    }

    public void removeInterface(Interface anInterface) {
        this.interfaces.remove(anInterface);
    }
}
