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
    private List<MethodOutput> outputs;
    private Map<String, Parameter> paramsMap;

    public List<MethodOutput> getOutputs() {
		return outputs;
	}

	public void setOutputs(List<MethodOutput> outputs) {
		this.outputs = outputs;
	}

	public Method() {
        this.paramsMap = new LinkedHashMap<>();
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
        paramsMap.values().forEach(p -> {
            paramTypes.add(p.getType());
        });
        return paramTypes;
    }
    
    public float getMethodFitness(){
 
    		float fitness;
    		int counter ; 
    		int frequence = 0; 
    		
    		for (int i=0; i < outputs.size(); i++){
    			counter = 0 ; 
    		for (int j = 0 ; j < outputs.size(); j++){
    		 if ( outputs.get(i).getReturnVal().equals(outputs.get(j).getReturnVal())) {
    			 counter = counter + 1 ;
    		}
    		} 
    		if  (counter > frequence) {
    		frequence = counter ; 
    		}
    		} 
    		
    		fitness=frequence/outputs.size();
    		return fitness;
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
//        if (this.returnVal != null) {
//            str.append(": ");
//            str.append(this.getReturnValType());
//        }
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
