package fr.inria.diverse.noveltytesting.visitor;

import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Method;
import fr.inria.diverse.noveltytesting.model.Parameter;

/**
 * Created by leiko on 17/10/14.
 */
public interface ModelVisitor {

    void visit(Interface i);

    void visit(Method m);

    void visit(Parameter p);
}
