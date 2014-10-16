package fr.inria.diverse.noveltytesting.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leiko on 16/10/14.
 */
public class Method {

    private String name;
    private String returnValType;
    private Object returnVal;

    private long execTime;
    private List<Double> cpuConsumptions;
    private List<Integer> memoryConsumptions;

    private Map<String, Parameter> paramsMap;

    public Method() {
        this.paramsMap = new HashMap<String, Parameter>();
        this.cpuConsumptions = new ArrayList<Double>();
        this.memoryConsumptions = new ArrayList<Integer>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Parameter> getParameters() {
        return new ArrayList<Parameter>(paramsMap.values());
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

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.name);
        str.append("(");
        List<Parameter> params = this.getParameters();
        for (int i=0; i < params.size(); i++) {
            str.append(params.get(i).toString());
            if (i+1 < params.size()) {
                str.append(", ");
            }
        }
        str.append(")");
        if (this.returnVal != null) {
            str.append(": ");
            str.append(this.getReturnValType());
        }
        return str.toString();
    }
}
