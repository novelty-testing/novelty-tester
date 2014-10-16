package fr.inria.diverse.noveltytesting.generator;

import fr.inria.diverse.noveltytesting.model.Parameter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leiko on 16/10/14.
 */
public abstract class AbstractGenerator implements Generator {

    @Override
    public List<Parameter> getData(Method m) {
        List<Parameter> params = new ArrayList<>();

        for (java.lang.reflect.Parameter p : m.getParameters()) {
            Parameter param = new Parameter();
            param.setName(p.getName());
            param.setType(p.getType().getTypeName());

            if (p.getType().getTypeName().equals("int")) {
                param.setValue(genInteger());
            } else if (p.getType().getTypeName().equals("long")) {
                param.setValue(genLong());
            } else if (p.getType().getTypeName().equals("double")) {
                param.setValue(genDouble());
            } else if (p.getType().getTypeName().equals("float")) {
                param.setValue(genFloat());
            } else if (p.getType().getTypeName().equals("char")) {
                param.setValue(genCharacter());
            } else if (p.getType().getTypeName().equals("short")) {
                param.setValue(genShort());
            } else if (p.getType().getTypeName().equals("byte")) {
                param.setValue(genByte());
            } else if (p.getType().getTypeName().equals("java.lang.String")) {
                param.setValue(genString());
            } else {
                param.setValue(null);
            }

            params.add(param);
        }

        return params;
    }

    protected abstract int genInteger();
    protected abstract long genLong();
    protected abstract double genDouble();
    protected abstract float genFloat();
    protected abstract char genCharacter();
    protected abstract short genShort();
    protected abstract byte genByte();
    protected abstract String genString();
}

