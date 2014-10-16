package fr.inria.diverse.noveltytesting;

import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Method;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test
 */
public class NoveltyGenerationTest {

    private NoveltyGeneration novelty;

    @Before
    public void testBefore() {
        novelty = new NoveltyGenerationImpl();
    }

    @Test()
    public void testTestClass() {
        try {
            Interface i = novelty.test("fr.inria.diverse.noveltytesting.model.Interface");
            List<Method> methods = i.getMethods();

            assertEquals(methods.size(), 5);

            for (Method m : methods) {
                if (m.getName().equals("getMethods")) {
                    assertEquals("getMethods nb param 0", 0, m.getParameters().size());
                    assertEquals("getMethods return type List", List.class.getTypeName(), m.getReturnValType());

                } else if (m.getName().equals("addMethod")) {
                    assertEquals("addMethod nb param 1", 1, m.getParameters().size());
                    assertEquals("addMethod return type Void", "void", m.getReturnValType());

                } else if (m.getName().equals("setName")) {
                    assertEquals("setName nb param 1", 1, m.getParameters().size());
                    assertEquals("setName return type Void", "void", m.getReturnValType());

                } else if (m.getName().equals("getName")) {
                    assertEquals("getName nb param 0", 0, m.getParameters().size());
                    assertEquals("getName return type String", String.class.getTypeName(), m.getReturnValType());

                } else if (m.getName().equals("toString")) {
                    assertEquals("toString nb param 0", 0, m.getParameters().size());
                    assertEquals("toString return type String", String.class.getTypeName(), m.getReturnValType());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
