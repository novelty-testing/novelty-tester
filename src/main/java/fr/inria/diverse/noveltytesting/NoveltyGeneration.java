package fr.inria.diverse.noveltytesting;

import fr.inria.diverse.noveltytesting.behaviour.Behaviour;
import fr.inria.diverse.noveltytesting.model.Interface;

/**
 * Created by leiko on 16/10/14.
 */
public interface NoveltyGeneration {

    /**
     * TODO
     * @param behaviour
     */
    void setBehaviour(Behaviour behaviour);

    /**
     * @param anInterface an interface to generate data for
     * @return Interface an inflated model with random generated data for each method
     */
    Interface test(Class<?> anInterface);

    /**
     * @param interfaceFQN fully qualified name of the interface to test (eg. fr.inria.diverse.Foo)
     * @return Interface an inflated model with random generated data for each method
     * @throws ClassNotFoundException
     */
    Interface test(String interfaceFQN) throws ClassNotFoundException;
}
