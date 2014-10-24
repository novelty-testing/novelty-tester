package fr.inria.diverse.noveltytesting.operator;

import fr.inria.diverse.noveltytesting.model.Interface;
import fr.inria.diverse.noveltytesting.model.Population;

import java.util.List;

/**
 * Created by leiko on 24/10/14.
 */
public class MutationOperator implements Operator {

    @Override
    public void process(Population population) {
        List<Interface> interfaces = population.getInterfaces();

        // TODO
        // Do not use this code below, rewrite it according to the new Population model etc

//        do {
//            for (int i = 0; i < interfaces.size() ;i++) {
//                Population pop = new Population();
//                for (int j = 0; j < interfaces.get(i).tc.size(); j++) {
//
//                    Object[] data=new RandomData().getMutationDataGenerated(selectedTestSequence.elementAt(i).tc.elementAt(j).m,selectedTestSequence.elementAt(i).tc.elementAt(j).data);
//
//                    outputs=new Vector<Object>();
//                    Object o =selectedTestSequence.elementAt(i).tc.elementAt(j).m.invoke(javaScriptEngine(), data);
//                    Object o1=jsScriptEngine().invokeFunction(selectedTestSequence.elementAt(i).tc.elementAt(j).m.getName() , data);
//
//
//                    //don't get methods with void return value
//                    if(o!=null&&o1!=null){
//                        outputs.add(o);
//                        outputs.add(o1);}
//
//
//                    TestCase tc=new TestCase (selectedTestSequence.elementAt(i).tc.elementAt(j).m,data,outputs);
//
//                    testSuite.addTestCase(tc);
//                }
//                newTestSequence.add(testSuite);
//            }
//
//        }while(newTestSequence.size()!=TestSequence.size());
    }
}
