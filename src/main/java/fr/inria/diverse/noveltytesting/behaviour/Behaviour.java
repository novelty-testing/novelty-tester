package fr.inria.diverse.noveltytesting.behaviour;

/**
 * Created by leiko on 16/10/14.
 */
public interface Behaviour {

    /**
     * Determine the distance, in behaviour space, between this Behaviour and the given Behaviour.
     * All distances should be in the range [0, 1].
     * @param b behaviour
     * @return double
     */
    double distanceFrom(Behaviour b);

    /**
     * Provide a default/suggested threshold. Should be in the range [0, 1].
     * @return double
     */
    double defaultThreshold();
}
