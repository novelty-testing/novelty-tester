package fr.inria.diverse.noveltytesting.behaviour;

import java.util.Vector;

import fr.inria.diverse.noveltytesting.model.Parameter;
import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Method;
import fr.inria.diverse.noveltytesting.model.Population;


/**
 * Created by leiko on 16/10/14.
 */

public class BehaviourImpl implements Behaviour {

	double noveltyMetric;

	public BehaviourImpl() {
		// TODO
	}

	@Override
	public double getNoveltyMetric() {
		return noveltyMetric;
	}

	@Override
	public void setNoveltyMetric(Interface anInterface, Population population,
			Population Archive) {

		noveltyMetric = getDistFromPopulation(anInterface, population)
				+ getDistFromArchive(anInterface, Archive);
	}

	public double getDistFromArchive(Interface anInterface, Population Archive) {
		double distFromArchive = 0;
		double dist;
		for (Interface i : Archive.getInterfaces()) {
			dist = distanceInterfaces(anInterface, i);
			distFromArchive += dist;
		}

		return distFromArchive;
	}

	public double getDistFromPopulation(Interface anInterface,
			Population population) {

		double distFromPopulation = 0;
		double dist;
		for (Interface i : population.getInterfaces()) {
			dist = distanceInterfaces(anInterface, i);
			distFromPopulation += dist;
		}

		return distFromPopulation;

	}

	public double distanceInterfaces(Interface interface1, Interface interface2) {
		double distanceInterfaces = 0;
		double dist;

		for (Method m : interface1.getMethods()) {
			dist = distanceMethods(
					interface1.getMethod(m.getName(), m.getParameterTypes()),
					interface2.getMethod(m.getName(), m.getParameterTypes()));
			distanceInterfaces += dist;
		}

		return distanceInterfaces;
	}

	public double distanceMethods(Method method1, Method method2) {

		double distanceMethods = 0;
		double dist;

		for (Parameter p : method1.getParameters()) {
			dist = distanceParameters(method1.getParamsMap().get(p.getName()),
					method2.getParamsMap().get(p.getName()));
			distanceMethods += dist;
		}
		return distanceMethods;
	}

	public double distanceParameters(Parameter parameter1, Parameter parameter2) {
		double distanceNumbers = 0;
		double distanceChar = 0;
		double distanceStrings = 0;

		double distanceParameters;

		if (parameter1.equals("int") || parameter1.equals("float")
				|| parameter1.equals("long") || parameter1.equals("double")
				|| parameter1.equals("byte") || parameter1.equals("short")) {
			distanceNumbers = distanceNumbers(parameter1.getValue(),
					parameter2.getValue());
		} else if (parameter1.equals("char")) {

			distanceChar = distanceChar(parameter1.getValue(),
					parameter2.getValue());
		} else if (parameter1.equals("java.lang.String")) {

			distanceStrings = distanceStrings(parameter1.getValue(),
					parameter2.getValue());
		}

		distanceParameters = distanceNumbers + distanceChar + distanceStrings;

		return distanceParameters;
	}

	public int distanceStrings(Object a, Object b) {

		String a1 = a.toString().toLowerCase();
		String b1 = b.toString().toLowerCase();

		int[] costs = new int[b1.length() + 1];
		for (int j = 0; j < costs.length; j++)
			costs[j] = j;
		for (int i = 1; i <= a1.length(); i++) {

			costs[0] = i;
			int nw = i - 1;
			for (int j = 1; j <= b1.length(); j++) {
				int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]),
						a1.charAt(i - 1) == b1.charAt(j - 1) ? nw : nw + 1);
				nw = costs[j];
				costs[j] = cj;
			}
		}
		return costs[b1.length()];
	}

	public int distanceChar(Object a, Object b) {
		char a1 = a.toString().charAt(0);
		char b1 = b.toString().charAt(0);
		int diff = Character.toLowerCase(a1) - Character.toLowerCase(b1);
		return diff;
	}

	public double distanceNumbers(Object a, Object b) {

		double diff = Double.parseDouble(a.toString())
				- Double.parseDouble(b.toString());
		return diff;
	}

}



