package fr.inria.diverse.noveltytesting.operator;

import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Population;

import java.util.List;

/**
 * Created by leiko on 24/10/14.
 */
public class CrossoverOperator implements Operator {

    @Override
    public void process(Population population) {
        List<Interface> interfaces = population.getInterfaces();

        // TODO
        // Do not use this code below, rewrite it according to the new Population model etc

//        int crossoverPoint = 0;
//        int crossoverMethodPosition = 0;
//        Object permute=null;
//
//        if (selectedTestSequenceSize>1) {
//
//            for (int i = 0; i < selectedTestSequenceSize-1 ;i++) {
//
//                //crossoverPoint= 0;
//                crossoverMethodPosition= (int) (Math.random() * selectedTestSequence.elementAt(i).tc.size());
//                crossoverPoint= (int) (Math.random() * selectedTestSequence.elementAt(i).tc.elementAt(crossoverMethodPosition).data.length);
//
//
//                permute=selectedTestSequence.elementAt(i).tc.elementAt(crossoverMethodPosition).data[crossoverPoint];
//                selectedTestSequence.elementAt(i).tc.elementAt(crossoverMethodPosition).data[crossoverPoint]=selectedTestSequence.elementAt(i+1).tc.elementAt(crossoverMethodPosition).data[crossoverPoint];
//                selectedTestSequence.elementAt(i+1).tc.elementAt(crossoverMethodPosition).data[crossoverPoint]=permute;
//
//
//                //System.out.println(selectedTestSequence.elementAt(i).tc.elementAt(crossoverMethodPosition).m.getName());
//                //System.out.println(crossoverMethodPosition);
//                //System.out.println(crossoverPoint);
//                //System.out.println(selectedTestSequence.elementAt(i).tc.elementAt(crossoverMethodPosition).data[crossoverPoint]);
//                //System.out.println(selectedTestSequence.elementAt(i+1).tc.elementAt(crossoverMethodPosition).data[crossoverPoint]);
//                //System.out.println();
//                //Object[] data=new RandomData().getMutationDataGenerated(selectedTestSequence.elementAt(i).tc.get(j).m,selectedTestSequence.elementAt(i).tc.get(j).data);
//                //selectedTestSequence.elementAt(i).tc.get(j).setData(data);
//
//                //TestCase tc=new TestCase (selectedTestSequence.elementAt(i).tc.get(j).m,data,null);
//
//                //testSuite.addTestCase(tc);
//
//            }
//            //newTestSequence.add(testSuite);
//        }
    }
}
