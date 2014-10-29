package fr.inria.diverse.noveltytesting.model;

import fr.inria.diverse.noveltytesting.behaviour.Behaviour;
import fr.inria.diverse.noveltytesting.visitor.Visitable;
import fr.inria.diverse.noveltytesting.visitor.Visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by leiko on 16/10/14.
 */
public class Interface implements Visitable {

    private String name;
    private List<Method> methods;
    private Behaviour behaviour;

    public Behaviour getBehaviour() {
		return behaviour;
	}

	public void setBehaviour(Behaviour b) {
		this.behaviour = b;
	}

	public Interface() {
        this.methods = new LinkedList<>();
    }

    public List<Method> getMethods() {
        return methods;
    }

    public void setMethods(List<Method> methods) {
        this.methods = methods;
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
    public void accept(Visitor visitor, boolean visitChildren, boolean isRecursive) {
        visitor.visit(this);
        if (visitChildren) {
            if (isRecursive) {
                methods.forEach(m -> m.accept(visitor, true, true));
            } else {
                methods.forEach(m -> m.accept(visitor, false, false));
            }
        }
    }

    @Override
    public void accept(Visitor visitor) {
        this.accept(visitor, true, true);
    }

    public float getFitness() {
        float fit = 0.0f;

        for (Method m : this.methods) {
            fit += m.getMethodFitness();
        }

        if (this.methods.size() > 0) {
            return fit / (float) this.methods.size();
        } else {
            return 1.0f;
        }
    }
}
