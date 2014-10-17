package fr.inria.diverse.noveltytesting.model;

import fr.inria.diverse.noveltytesting.visitor.Visitable;
import fr.inria.diverse.noveltytesting.visitor.ModelVisitor;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by leiko on 16/10/14.
 */
public class Interface implements Visitable {

    private String name;
    private List<Method> methods;

    public Interface() {
        this.methods = new LinkedList<Method>();
    }

    public List<Method> getMethods() {
        return methods;
    }

    public Method getMethod(String name, List<String> paramTypes) {
        for (Method m : this.methods) {
            if (m.getName().equals(name) && m.getParameterTypes().equals(paramTypes)) {
                return m;
            }
        }

        return null;
    }

    public void addMethod(Method m) {
        this.methods.add(m);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.name);
        str.append("\n");
        for (Method m : this.methods) {
            str.append("\t");
            str.append(m.toString());
            str.append("\n");
        }
        return str.toString();
    }

    @Override
    public void accept(ModelVisitor visitor) {
        visitor.visit(this);
    }
}
