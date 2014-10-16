package fr.inria.diverse.noveltytesting.generator;

import fr.inria.diverse.noveltytesting.model.Parameter;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by leiko on 16/10/14.
 */
public interface Generator {

    /**
     * Returns a list of parameter with some generated data
     * @param m Method used to generate data
     * @return List<Parameter> a list of Parameter
     */
    List<Parameter> getData(Method m);
}
