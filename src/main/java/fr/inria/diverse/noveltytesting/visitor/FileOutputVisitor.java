package fr.inria.diverse.noveltytesting.visitor;

import fr.inria.diverse.noveltytesting.model.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Created by leiko on 05/11/14.
 */
public class FileOutputVisitor extends AbstractModelVisitor {

    private FileWriter writer;

    @Override
    public void visit(Population p) {
        for (Interface i : p.getInterfaces()) {
            i.accept(this);
        }
    }

    @Override
    public void visit(Interface i) {
        try {
            File file = File.createTempFile(i.getName(), ".log");
            writer = new FileWriter(file);
            writer.write("Model: " + i.getName() + "\n");
            writer.write("Novelty Metric: " + i.getNoveltyMetric() + "\n");
            writer.write("Fitness Value: " + i.getFitness() + "\n");
            for (Method m : i.getMethods()) {
                m.accept(this);
            }
            writer.flush();
            writer.close();
            System.out.println("Interface logs: "+file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        if (m.getMethodOutputs() != null) {
            str.append("outputs:\n");
            str.append("\t");

            for (Map.Entry<String, MethodOutput> entry : m.getMethodOutputs().entrySet()) {
                str.append(entry.getValue().getReturnVal());
                str.append(" (");
                str.append(entry.getKey());
                str.append(")");
                str.append("\n\t");
            }

        }

        try {
            writer.write(str.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visit(Parameter p) {}
}
