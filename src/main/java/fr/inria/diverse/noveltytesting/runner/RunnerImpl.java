package fr.inria.diverse.noveltytesting.runner;

import fr.inria.diverse.noveltytesting.model.Method;

/**
 * This class runs the methods of the given Interface model using the generated
 * data for the different parameters
 *
 * Created by leiko on 17/10/14.
 */
public class RunnerImpl implements Runner {

    @Override
    public void exec(Object instance, java.lang.reflect.Method binMethod, Method method) {
        try {
            Object returnVal = binMethod.invoke(instance, method.getParametersValue());
            if (returnVal != null) {
                method.setReturnVal(returnVal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
