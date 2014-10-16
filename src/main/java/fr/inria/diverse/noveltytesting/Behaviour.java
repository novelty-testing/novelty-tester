package fr.inria.diverse.noveltytesting;


import java.util.List;

/**
 * Interface for a behaviour in {@link NoveltySearch}.
 */
public abstract class Behaviour {
	/**
	 * Determine the distance, in behaviour space, between this Behaviour and the given Behaviour.
	 * All distances should be in the range [0, 1].
	 */
	public abstract double distanceFrom(Behaviour b);
	
	/**
	 * Provide a default/suggested threshold. Should be in the range [0, 1].
	 */
	public abstract double defaultThreshold();
	
	/**
	 * Subclasses may override this method to render a list of behaviours as an image for logging/visualisation purposes.
	 */
	public void renderArchive(List<Behaviour> archive, String fileName) {
	}
}
