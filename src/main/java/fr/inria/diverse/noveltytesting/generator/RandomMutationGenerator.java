package fr.inria.diverse.noveltytesting.generator;

import java.util.Random;

import fr.inria.diverse.noveltytesting.generator.AbstractGenerator;
import fr.inria.diverse.noveltytesting.model.Parameter;


/**
 * @author mboussaa
 *
 */

public class RandomMutationGenerator extends AbstractGenerator {

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "0123456789" +
            "&é\"'(-è_çà)=ù*^,;:!?./§~#{[|`\\^@]}]+*²<>%µ£¨";
    
    private int rangeMutation = 50;
    

    @Override
    protected int genInteger(Parameter p) {
    	
		int min = (Integer) p.getValue()-rangeMutation;
		int max = (Integer) p.getValue()+rangeMutation;

        return (int) (min + (Math.random() * (max - min)));
    }

    @Override
    protected long genLong(Parameter p) {

    	long min = (Long) p.getValue()-rangeMutation;
    	long max = (Long) p.getValue()+rangeMutation;

        return (long) (min + (Math.random() * (max - min)));
    }     

    @Override
    protected double genDouble(Parameter p) {
    	double min = (double) p.getValue()-rangeMutation;
    	double max = (double) p.getValue()+rangeMutation;

        return min + new Random().nextFloat() * (max - min);
    }

    @Override
    protected float genFloat(Parameter p) {
    	
    	float min = (float) p.getValue()-rangeMutation;
    	float max = (float) p.getValue()+rangeMutation;

        return min + new Random().nextFloat() * (max - min);
    }

    @Override
    protected char genCharacter(Parameter p) {
    	char res;
    	
    	int pos=CHARACTERS.indexOf((char)p.getValue());
    	if ((pos+1)==CHARACTERS.length()){
    		res=CHARACTERS.charAt(0);
    	}else{
    		res=CHARACTERS.charAt(pos+1);
    	}

        return res;
    }

    @Override
    protected short genShort(Parameter p) {
    	
    	short min = (short) ((short)p.getValue()-rangeMutation);
    	short max =  (short) ((short)p.getValue()-rangeMutation);

        return (short) (min + (Math.random() * (max - min)));
    }

    @Override
    protected byte genByte(Parameter p) {
    	
    	byte min = (byte) ((byte) p.getValue()-rangeMutation);
    	byte max =  (byte) ((byte)p.getValue()-rangeMutation);

        return (byte) (min + (Math.random() * (max - min)));
     
    }

    @Override
    protected boolean genBoolean(Parameter p) {
        return !(Boolean) p.getValue();
    }

    @Override
    protected String genString(Parameter p) {
        StringBuilder str = new StringBuilder((String)p.getValue());
        int nbMutations = str.length()/2;
        while (nbMutations > 0) {
        	int pos= (int) (Math.random() * str.length() );
            str.setCharAt(pos, CHARACTERS.charAt((int) (Math.random() * CHARACTERS.length())));
            nbMutations--;
        }
        return str.toString();
    }
}
