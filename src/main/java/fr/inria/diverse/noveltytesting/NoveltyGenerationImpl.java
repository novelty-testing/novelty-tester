package fr.inria.diverse.noveltytesting;

import fr.inria.diverse.noveltytesting.behaviour.Behaviour;
import fr.inria.diverse.noveltytesting.generator.Generator;
import fr.inria.diverse.noveltytesting.generator.RandomGenerator;
import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Method;

/**
 * Created by leiko on 16/10/14.
 */
public class NoveltyGenerationImpl implements NoveltyGeneration {

    private Behaviour behaviour;
    private Generator generator = new RandomGenerator();

    @Override
    public void setBehaviour(Behaviour behaviour) {
        this.behaviour = behaviour;
    }

    @Override
    public Interface test(Class<?> anInterface) {
        Interface i = new Interface();
        i.setName(anInterface.getName());
        for (java.lang.reflect.Method m : anInterface.getDeclaredMethods()) {
            Method method = new Method();
            method.setName(m.getName());
            method.setReturnValType(m.getReturnType().getTypeName());
            method.addParameters(generator.getData(m));
            i.addMethod(method);
        }
        return i;
    }

    @Override
    public Interface test(String interfaceFQN) throws ClassNotFoundException {
        return this.test(Class.forName(interfaceFQN));
    }
}
