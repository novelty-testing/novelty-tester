package fr.inria.diverse.noveltytesting.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leiko on 16/10/14.
 */
public class Interface {

    private String name;
    private List<Method> methods;

    public Interface() {
        this.methods = new ArrayList<Method>();
    }

    public List<Method> getMethods() {
        return methods;
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
}
