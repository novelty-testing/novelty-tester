package fr.inria.diverse.noveltytesting.visitor;

/**
 * Created by leiko on 17/10/14.
 */
public interface Visitable {

    void accept(ModelVisitor visitor);
}
