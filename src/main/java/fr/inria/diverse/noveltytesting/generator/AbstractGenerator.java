package fr.inria.diverse.noveltytesting.generator;

import fr.inria.diverse.noveltytesting.model.Method;
import fr.inria.diverse.noveltytesting.model.Parameter;

/**
 * Generates random data for the different parameters of a given Method
 *
 * Created by leiko on 16/10/14.
 */
public abstract class AbstractGenerator implements Generator {

    @Override
    public void generateData(Method m) {
        for (Parameter p : m.getParameters()) {
            if (p.getType().equals("int") || p.getType().equals("java.lang.Integer")) {
                p.setValue(genInteger());
            } else if (p.getType().equals("long") || p.getType().equals("java.lang.Long")) {
                p.setValue(genLong());
            } else if (p.getType().equals("double") || p.getType().equals("java.lang.Double")) {
                p.setValue(genDouble());
            } else if (p.getType().equals("float") || p.getType().equals("java.lang.Float")) {
                p.setValue(genFloat());
            } else if (p.getType().equals("char") || p.getType().equals("java.lang.Character")) {
                p.setValue(genCharacter());
            } else if (p.getType().equals("short") || p.getType().equals("java.lang.Short")) {
                p.setValue(genShort());
            } else if (p.getType().equals("byte") || p.getType().equals("java.lang.Byte")) {
                p.setValue(genByte());
            } else if (p.getType().equals("boolean") || p.getType().equals("java.lang.Boolean")) {
                p.setValue(genBoolean());
            } else if (p.getType().equals("java.lang.String")) {
                p.setValue(genString());
            } else {
                p.setValue(null);
            }
        }
    }

    protected abstract int genInteger();
    protected abstract long genLong();
    protected abstract double genDouble();
    protected abstract float genFloat();
    protected abstract char genCharacter();
    protected abstract short genShort();
    protected abstract byte genByte();
    protected abstract boolean genBoolean();
    protected abstract String genString();
}

