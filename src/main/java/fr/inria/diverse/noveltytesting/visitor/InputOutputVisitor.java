package fr.inria.diverse.noveltytesting.visitor;

import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Method;
import fr.inria.diverse.noveltytesting.model.MethodOutput;
import fr.inria.diverse.noveltytesting.model.Parameter;

import java.util.Map;

/**
 * Created by leiko on 17/10/14.
 */
public class InputOutputVisitor extends AbstractModelVisitor {

    @Override
    public void visit(Interface i) {
        System.out.println("\n\n\nModel: " + i.getName());
        System.out.println("Novelty Metric: " + i.getBehaviour().getNoveltyMetric());
        System.out.println("Fitness Value: " + i.getFitness());
    }

    @Override
    public void visit(Method m) {
        StringBuilder str = new StringBuilder();
        str.append("========= ");
        str.append(m.getName());
        str.append(": ");
        if (m.getReturnValType() == null) {
            str.append("Void");
        } else {
            str.append(m.getReturnValType());
        }
        str.append(" =========");
        str.append("\n");
        str.append("inputs:\n");
        Object[] paramValues = m.getParametersValue();
        for (int i=0; i < paramValues.length; i++) {
            str.append("\t");
            str.append(paramValues[i]);
            if (i<paramValues.length-1) {
                str.append("\n");
            }
        }
        str.append("\n");
        str.append("outputs:\n");

        str.append("\t");
        //str.append(m.getReturnVal());

        for (Map.Entry<String, MethodOutput> entry : m.getMethodOutputs().entrySet()) {
            str.append("\t");
            str.append(entry.getValue().getReturnVal());
            str.append(" (");
            str.append(entry.getKey());
            str.append(")");
        }

        System.out.println(str.toString());
    }

    @Override
    public void visit(Parameter p) {}
}
