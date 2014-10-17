package fr.inria.diverse.noveltytesting;

import fr.inria.diverse.noveltytesting.model.Interface;

/**
 * Created by leiko on 16/10/14.
 */
public interface NoveltyGeneration {

    Interface generateModel(Class<?> clazz);

    void generateData(Interface anInterface);

    void executeMethods(Interface anInterface);

    Interface generateModel(String interfaceFQN) throws ClassNotFoundException;
}
