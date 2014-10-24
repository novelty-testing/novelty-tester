package fr.inria.diverse.noveltytesting.modelgeneration;

import fr.inria.diverse.noveltytesting.generator.Generator;
import fr.inria.diverse.noveltytesting.model.Interface;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by leiko on 16/10/14.
 */
public interface ModelGeneration {

    void setGenerator(Generator gen);

    Interface generateModel(Class<?> clazz);

    void generateData(Interface anInterface);

    void executeMethods(Interface anInterface)
            throws InstantiationException, InvocationTargetException, NoSuchMethodException, IllegalAccessException;

    Interface generateModel(String interfaceFQN)
            throws ClassNotFoundException;
}
