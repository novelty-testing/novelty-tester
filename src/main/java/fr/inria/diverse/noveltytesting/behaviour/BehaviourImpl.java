package fr.inria.diverse.noveltytesting.behaviour;

import fr.inria.diverse.noveltytesting.model.Parameter;
import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Method;
import fr.inria.diverse.noveltytesting.model.Population;


/**
 * Created by leiko on 16/10/14.
 */

public class BehaviourImpl implements Behaviour {

    public double getDistance(Interface i, Population pop, Population archive) {
        return getDistance(i, pop) + getDistance(i, archive);
    }

    private double getDistance(Interface anInterface, Population population) {
		double distFromPopulation = 0;
		for (Interface i : population.getInterfaces()) {
			distFromPopulation += getDistance(anInterface, i);
		}
		return distFromPopulation;

	}

    private double getDistance(Interface interface1, Interface interface2) {
		double distanceInterfaces = 0;
		for (Method m : interface1.getMethods()) {
			distanceInterfaces += getDistance(
                    interface1.getMethod(m.getName(), m.getParameterTypes()),
                    interface2.getMethod(m.getName(), m.getParameterTypes()));
		}

		return distanceInterfaces;
	}

    private double getDistance(Method method1, Method method2) {
		double distanceMethods = 0;
		for (Parameter p : method1.getParameters()) {
			distanceMethods += getDistance(method1.getParamsMap().get(p.getName()),
                    method2.getParamsMap().get(p.getName()));
		}
		
		return distanceMethods;
	}

    private double getDistance(Parameter parameter1, Parameter parameter2) {
		double distanceNumbers = 0;
		double distanceChar = 0;
		double distanceStrings = 0;

		double distanceParameters;

		if (parameter1.getType().equals("int") || parameter1.getType().equals("float")
				|| parameter1.getType().equals("long") || parameter1.getType().equals("double")
				|| parameter1.getType().equals("byte") || parameter1.getType().equals("short")) {
			distanceNumbers = getDistance((Number) parameter1.getValue(), (Number) parameter2.getValue());

		} else if (parameter1.getType().equals("char")) {
			distanceChar = getDistance((char) parameter1.getValue(), (char) parameter2.getValue());

		} else if (parameter1.getType().equals("java.lang.String")) {
			distanceStrings = getDistance((String) parameter1.getValue(), (String) parameter2.getValue());
		}

		distanceParameters = distanceNumbers + distanceChar + distanceStrings;

		return distanceParameters;
	}

    private int getDistance(String a, String b) {
		String a1 = a.toLowerCase();
		String b1 = b.toLowerCase();

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
		return Math.abs(costs[b1.length()]);
	}

    private int getDistance(char a, char b) {
        return Math.abs(Character.toLowerCase(a) - Character.toLowerCase(b));
	}

    private double getDistance(Number a, Number b) {
        return Math.abs(a.doubleValue() - b.doubleValue());
	}
}



