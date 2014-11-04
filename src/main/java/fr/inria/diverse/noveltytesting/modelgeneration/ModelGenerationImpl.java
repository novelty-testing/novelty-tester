package fr.inria.diverse.noveltytesting.modelgeneration;

import fr.inria.diverse.noveltytesting.generator.Generator;
import fr.inria.diverse.noveltytesting.generator.RandomGenerator;
import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Method;
import fr.inria.diverse.noveltytesting.model.Parameter;
import fr.inria.diverse.noveltytesting.runner.Runner;
import fr.inria.diverse.noveltytesting.runner.RunnerImpl;
import java.lang.reflect.InvocationTargetException;


/**
 * Generates a model for a given interface
 * Generates data for a given interface
 * Executes data on different target platforms
 * 
 * Created by leiko on 16/10/14.
 */
public class ModelGenerationImpl implements ModelGeneration {

    private Generator generator = new RandomGenerator();
    private Runner runner = new RunnerImpl();


    @Override
    public void setGenerator(Generator gen) {
        this.generator = gen;
    }

    @Override
    public Interface generateModel(Class<?> clazz) {
        Interface i = new Interface();
        i.setName(clazz.getName());

        for (java.lang.reflect.Method m : clazz.getDeclaredMethods()) {
            Method method = new Method();
            method.setName(m.getName());
            method.setReturnValType(m.getReturnType().getTypeName());

            for (java.lang.reflect.Parameter p : m.getParameters()) {
                Parameter param = new Parameter();
                param.setName(p.getName());
                param.setType(p.getType().getTypeName());
                method.addParameter(param);
            }
            i.addMethod(method);
        }

        return i;
    }

    @Override
    public void generateData(Interface anInterface) {
        anInterface.getMethods().forEach(this.generator::generateData);
    }

    @Override
    public void executeMethods(Interface anInterface)
            throws InstantiationException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        try {
            Class<?> clazz = Class.forName(anInterface.getName());
            runner.exec(clazz, anInterface);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Interface generateModel(String interfaceFQN) throws ClassNotFoundException {
        return this.generateModel(Class.forName(interfaceFQN));
    }



}
