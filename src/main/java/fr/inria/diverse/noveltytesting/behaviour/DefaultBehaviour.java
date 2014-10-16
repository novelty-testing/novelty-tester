package fr.inria.diverse.noveltytesting.behaviour;

/**
 * Created by leiko on 16/10/14.
 */
public class DefaultBehaviour extends AbstractBehaviour {

    @Override
    public double distanceFrom(Behaviour b) {
        return 0;
    }

    @Override
    public double defaultThreshold() {
        return 0;
    }
}
