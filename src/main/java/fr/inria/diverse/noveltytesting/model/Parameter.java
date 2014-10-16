package fr.inria.diverse.noveltytesting.model;

/**
 * Created by leiko on 16/10/14.
 */
public class Parameter {

    private String name;
    private String type;
    private Object value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return getType() + ": " + this.name + " (" + this.getValue() + ")";
    }
}
