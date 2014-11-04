package fr.inria.diverse.noveltytesting.model;

import fr.inria.diverse.noveltytesting.visitor.Visitable;
import fr.inria.diverse.noveltytesting.visitor.Visitor;

import java.util.*;

/**
 * a method has a name, a return value type, a list of parameters and list of outputs from the different target platforms
 * 
 * we associate a list of outputs to each target platform 
 * 
 * getMethodFitness() : is a comparison metric that compares the different outputs 
 * 
 * Created by leiko on 16/10/14.
 */
public class Method implements Visitable {

    private String name;
    private String returnValType;
    private Map<String, MethodOutput> outputs;
    private Map<String, Parameter> paramsMap;

    public Method() {
        this.outputs = new HashMap<>();
        this.paramsMap = new LinkedHashMap<>();
    }

    public Map<String, MethodOutput> getMethodOutputs() {
        return outputs;
    }

    public void setOutputs(Map<String, MethodOutput> outputs) {
        this.outputs = outputs;
    }

    public MethodOutput getOutput(String key) {
        return this.outputs.get(key);
    }

    public List<MethodOutput> getMethodOutputsList() {
        List<MethodOutput> outputs = new LinkedList<>();
        this.outputs.values().forEach(outputs::add);
        return outputs;
    }

    public void addMethodOutput(String key, MethodOutput mo) {
        this.outputs.put(key, mo);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Parameter> getParameters() {
        return new LinkedList<>(paramsMap.values());
    }

    public void addParameter(Parameter p) {
        this.paramsMap.put(p.getName(), p);
    }

    public void addParameters(List<Parameter> params) {
        for (Parameter p : params) {
            this.paramsMap.put(p.getName(), p);
        }
    }

    public String getReturnValType() {
        return returnValType;
    }

    public void setReturnValType(String returnValType) {
        this.returnValType = returnValType;
    }

    public Map<String, Parameter> getParamsMap() {
        return paramsMap;
    }

    public void setParamsMap(Map<String, Parameter> paramsMap) {
        this.paramsMap = paramsMap;
    }

    public List<String> getParameterTypes() {
        List<String> paramTypes = new LinkedList<>();
        paramsMap.values().forEach(p -> paramTypes.add(p.getType()));
        return paramTypes;
    }

    public float getMethodFitness() {
        int counter;
        int frequency = 0;

        for (Map.Entry<String, MethodOutput> entry : outputs.entrySet()) {
            counter = 0;
            for (MethodOutput output : outputs.values()) {
                if (output.getReturnVal().equals(entry.getValue().getReturnVal())) {
                    counter = counter + 1;
                }
            }
            if (counter > frequency) {
                frequency = counter;
            }
        }

        if (outputs.size() == 0) {
            return 1.0f;
        } else {
            return (float) (frequency / outputs.size());
        }
    }

    public Object[] getParametersValue() {
        Object[] paramValues = new Object[paramsMap.size()];
        Parameter[] params = new Parameter[paramsMap.size()];
        paramsMap.values().toArray(params);
        for (int i=0; i < params.length; i++) {
            paramValues[i] = params[i].getValue();
        }
        return paramValues;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.name);
        str.append(": ");
        str.append(this.getReturnValType());
        str.append("\n");
        this.getParameters().forEach(p -> {
            str.append("\t\t");
            str.append(p.toString());
            str.append("\n");
        });
        return str.toString();
    }

    @Override
    public void accept(Visitor visitor, boolean visitChildren, boolean isRecursive) {
        visitor.visit(this);
        if (visitChildren) {
            if (isRecursive) {
                paramsMap.values().forEach(p -> p.accept(visitor, true, true));
            } else {
                paramsMap.values().forEach(p -> p.accept(visitor, false, false));
            }
        }
    }

    @Override
    public void accept(Visitor visitor) {
        this.accept(visitor, true, true);
    }
}
