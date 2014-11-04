package fr.inria.diverse.noveltytesting.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A population must have a fixed size provided by the client
 * 
 * A population depends to only one Class<?> (Services'interface)
 * 
 * getRelevantModels() return The list of interfaces that have generated
 * incoherence in the outputs taking into account the fitness value
 * 
 * getEmptyInterfaces() returns the number of interfaces removed after each
 * selection in order to fulfill the population
 * 
 * 
 * @author leiko
 *
 */

public class Population {

	private List<Interface> interfaces;
	private int size;
	private Class<?> clazz;

	public Population() {
		this.interfaces = new ArrayList<>();
	}

	public Population(int n) {
		this.interfaces = new ArrayList<>();
		this.size = n;
	}

	public Population(int n, Class<?> clazz) {
		this.interfaces = new ArrayList<>();
		this.size = n;
		this.clazz = clazz;
	}

	public List<Interface> getInterfaces() {
		return interfaces;
	}

	public void addInterfaces(List<Interface> interfaces) {
		this.interfaces.addAll(interfaces);
	}

	public void addInterface(Interface i) {
		this.interfaces.add(i);
	}

	public List<Interface> getRelevantModels() {
		return this.interfaces.stream().filter(i -> i.getFitness() < 1)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	public void removeInterface(Interface anInterface) {
		this.interfaces.remove(anInterface);
	}

	public int getSize() {
		return size;
	}

	public int setSize(int n) {
		return this.size = n;
	}

	public int getEmptyInterfaces() {
		return this.getSize() - this.getInterfaces().size();
	}
}
