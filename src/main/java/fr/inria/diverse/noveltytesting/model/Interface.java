package fr.inria.diverse.noveltytesting.model;

import fr.inria.diverse.noveltytesting.behaviour.Behaviour;
import fr.inria.diverse.noveltytesting.behaviour.BehaviourImpl;
import fr.inria.diverse.noveltytesting.visitor.Visitable;
import fr.inria.diverse.noveltytesting.visitor.Visitor;

import java.util.LinkedList;
import java.util.List;

/** 
 * an interface belongs to only one services'interface
 * an interface holds a list of services
 * an interface has a fitness value (1st metric): 1 if the outputs are similar <1 if there is any incoherence
 * an interface has a behaviour (2nd metric) which handles the novelty metric
 * 
 * Created by leiko on 16/10/14.
 */
public class Interface implements Visitable {

    private String name;
    private List<Method> methods;
    private double noveltyMetric;

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

    public double getNoveltyMetric() {
        return noveltyMetric;
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

    public void processNoveltyMetric(Population current, Population archive) {
        Behaviour b = new BehaviourImpl();
        noveltyMetric = b.getDistance(this, current, archive);
    }
}
