package fr.inria.diverse.noveltytesting;

import fr.inria.diverse.noveltytesting.model.Population;
import fr.inria.diverse.noveltytesting.modelgeneration.ModelGeneration;
import fr.inria.diverse.noveltytesting.modelgeneration.ModelGenerationImpl;
import fr.inria.diverse.noveltytesting.noveltyengine.NoveltyEngine;
import fr.inria.diverse.noveltytesting.noveltyengine.NoveltyEngineImpl;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test
 */
public class NoveltyGenerationTest {

    private ModelGeneration novelty;

    @Before
    public void testBefore() {
        novelty = new ModelGenerationImpl();
    }

    @Test
    public void testTestClass() throws Exception {
        NoveltyEngine engine = new NoveltyEngineImpl();
        Population population = engine.generatePopulation("fr.inria.diverse.noveltytesting.samples.FooClass", 10);
        // TODO
    }
}
