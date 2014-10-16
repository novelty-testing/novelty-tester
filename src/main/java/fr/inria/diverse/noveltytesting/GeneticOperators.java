package fr.inria.diverse.noveltytesting;

import fr.inria.diverse.noveltytesting.behaviour.AbstractBehaviour;
import fr.inria.diverse.noveltytesting.behaviour.Behaviour;
import fr.inria.diverse.noveltytesting.generator.Generator;
import fr.inria.diverse.noveltytesting.generator.RandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class GeneticOperators {

//    private double archiveThreshold = 0;
//    private List<Behaviour> archive;
//    private List<Behaviour> currentPop;
//    private List<Behaviour> toArchive;
//    private double addProbability;
//    private Behaviour b;
//    private Vector<Object> outputs;
//    private Vector<TestSuite> testSequence;
//    private Vector<TestSuite> selectedTestSequence;
//    private int selectedTestSequenceSize;
//    private Generator randomGen;
//
//    public GeneticOperators(Vector<TestSuite> testSequence) {
//        this.testSequence = testSequence;
//        this.randomGen = new RandomGenerator();
//    }
//
//    public double testNovelty(Behaviour b) {
//        int k = 30;
//        this.archive = new ArrayList<Behaviour>(k);
//        this.addProbability = 0;
//        int totalSize = this.archive.size() + this.currentPop.size();
//        double[] dist = new double[totalSize];
//        int i = 0;
//        int inArchiveCount = 0;
//        for (Behaviour b2 : this.archive) {
//            dist[i] = b.distanceFrom(b2);
//            if (dist[i] < 0.0000001) {
//                inArchiveCount++;
//            }
//            i++;
//        }
//
//        for (Behaviour b2 : this.currentPop) {
//            dist[i] = b.distanceFrom(b2);
//            i++;
//        }
//        int kTemp = Math.min(totalSize, k);
//        Arrays.sort(dist);
//        double avgDist = 0;
//        for (i = 0; i < kTemp; i++) {
//            avgDist += dist[i];
//        }
//        avgDist /= kTemp;
//
//        if (inArchiveCount < k) {
//            if (this.addProbability > 0) {
//                this.toArchive.add(b);
//
//            } else { // Using threshold archive addition method.
//                if (this.archiveThreshold == 0) {
//                    this.archiveThreshold = b.defaultThreshold();
//                }
//                this.toArchive.add(b);
//            }
//        }
//
//        return avgDist;
//    }
//
//    public void noveltySelection() {
//        for (int i = 0; i < this.testSequence.size(); i++) {
//            if (this.testSequence.elementAt(i).tc.size()>0) {
//                testNovelty(this.b);
//            }
//        }
//    }
//
//
//    public void selection() {
//        selectedTestSequence= new Vector<TestSuite>();
//        for (int i = 0; i < testSequence.size(); i++) {
//            if (testSequence.elementAt(i).getTestSuiteFitnessValue()<1) {
//                selectedTestSequence.add(testSequence.elementAt(i));
//            }
//        }
//        selectedTestSequenceSize=selectedTestSequence.size();
//    }
//
//    public void mutation() {
//        outputs=new Vector<Object>();
//        for (int i = 0; i < selectedTestSequence.size() ;i++) {
//            for (int j = 0; j < selectedTestSequence.elementAt(i).tc.size(); j++) {
//                Object[] data = this.randomGen.getData(selectedTestSequence.elementAt(i).tc.get(j).m);
//                // TODO something with data
//            }
//        }
//    }
//
//    public void crossover() {
//        if (selectedTestSequence.size()>0) {
//            for (int i = 0; i < selectedTestSequence.size() ;i++) {
//                for (int j = 0; j < selectedTestSequence.elementAt(i).tc.size(); j++) {
//                    Object[] data = this.randomGen.getData(selectedTestSequence.elementAt(i).tc.get(j).m);
//                    // TODO something with data
//                }
//            }
//        }
//    }
}

	
	
	
	
	
	
	
	
	