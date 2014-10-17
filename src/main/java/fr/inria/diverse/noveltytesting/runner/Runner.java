package fr.inria.diverse.noveltytesting.runner;

import fr.inria.diverse.noveltytesting.model.Method;

/**
 * Created by leiko on 16/10/14.
 */
public interface Runner {

    /**
     * Executes given binMethod using instance as base instance object and the data
     * contained in modelMethod parameters for parameter values
     * @param instance
     * @param binMethod
     * @param modelMethod
     */
    void exec(Object instance, java.lang.reflect.Method binMethod, Method modelMethod);
}
