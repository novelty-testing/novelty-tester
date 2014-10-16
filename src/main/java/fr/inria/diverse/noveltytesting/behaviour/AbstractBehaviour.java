package fr.inria.diverse.noveltytesting.behaviour;


/**
 * Interface for a behaviour in NoveltySearch.
 */
public abstract class AbstractBehaviour implements Behaviour {

    @Override
	public abstract double distanceFrom(Behaviour b);

    @Override
	public abstract double defaultThreshold();
}
