package fr.inria.diverse.noveltytesting.visitor;

import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Method;
import fr.inria.diverse.noveltytesting.model.Parameter;

/**
 * Created by leiko on 17/10/14.
 */
public class StdoutModelVisitor implements ModelVisitor {

    @Override
    public void visit(Interface i) {
        System.out.println(i.toString());
    }

    @Override
    public void visit(Method m) {}

    @Override
    public void visit(Parameter p) {}
}
