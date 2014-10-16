package fr.inria.diverse.noveltytesting.runner;

import fr.inria.diverse.noveltytesting.model.Interface;

/**
 * Created by leiko on 16/10/14.
 */
public interface Runner {

    /**
     * Supposed to execute the different interface given in the Interface model
     * and modify its state accordingly
     * @param anInterface Interface model
     */
    void exec(Interface anInterface);
}
