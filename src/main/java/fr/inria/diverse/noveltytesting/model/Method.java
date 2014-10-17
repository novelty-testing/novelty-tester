package fr.inria.diverse.noveltytesting.model;

import fr.inria.diverse.noveltytesting.visitor.Visitable;
import fr.inria.diverse.noveltytesting.visitor.Visitor;

import java.util.*;

/**
 * Created by leiko on 16/10/14.
 */
public class Method implements Visitable {

    private String name;
    private String returnValType;
    private Object returnVal;

    private long execTime;
    private List<Double> cpuConsumptions;
    private List<Integer> memoryConsumptions;

    private Map<String, Parameter> paramsMap;

    public Method() {
        this.paramsMap = new LinkedHashMap<>();
        this.cpuConsumptions = new LinkedList<>();
        this.memoryConsumptions = new LinkedList<>();
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

    public Object getReturnVal() {
        return returnVal;
    }

    public String getReturnValType() {
        return returnValType;
    }

    public void setReturnValType(String returnValType) {
        this.returnValType = returnValType;
    }

    public void setReturnVal(Object returnVal) {
        this.returnVal = returnVal;
    }

    public long getExecTime() {
        return execTime;
    }

    public void setExecTime(long execTime) {
        this.execTime = execTime;
    }

    public List<Double> getCpuConsumptions() {
        return cpuConsumptions;
    }

    public void setCpuConsumption(double cpuConsumption) {
        this.cpuConsumptions.add(cpuConsumption);
    }

    public List<Integer> getMemoryConsumptions() {
        return memoryConsumptions;
    }

    public void addMemoryConsumption(int memoryConsumption) {
        this.memoryConsumptions.add(memoryConsumption);
    }

    public List<String> getParameterTypes() {
        List<String> paramTypes = new LinkedList<>();
        paramsMap.values().forEach(p -> {
            paramTypes.add(p.getType());
        });
        return paramTypes;
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
        if (this.returnVal != null) {
            str.append(": ");
            str.append(this.getReturnValType());
        }
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
