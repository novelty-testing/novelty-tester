package fr.inria.diverse.noveltytesting.model;

import fr.inria.diverse.noveltytesting.visitor.Visitable;
import fr.inria.diverse.noveltytesting.visitor.Visitor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author leiko
 *
 */

public class Population implements Visitable {

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

    @Override
    public void accept(Visitor visitor, boolean visitChildren, boolean isRecursive) {
        visitor.visit(this);
        if (visitChildren) {
            if (isRecursive) {
                interfaces.forEach(i -> i.accept(visitor, true, true));
            } else {
                interfaces.forEach(i -> i.accept(visitor, false, false));
            }
        }
    }

    @Override
    public void accept(Visitor visitor) {
        this.accept(visitor, true, true);
    }
}
