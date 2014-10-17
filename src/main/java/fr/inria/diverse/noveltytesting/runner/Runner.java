package fr.inria.diverse.noveltytesting.runner;

import fr.inria.diverse.noveltytesting.model.Interface;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by leiko on 16/10/14.
 */
public interface Runner {

    /**
     * Executes the different methods of the given model
     * @param clazz
     * @param anInterface
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    void exec(Class<?> clazz, Interface anInterface)
            throws InstantiationException, NoSuchMethodException, IllegalAccessException, InvocationTargetException;
}
