package fr.inria.diverse.noveltytesting.generator;

import java.util.Random;

/**
 * Created by leiko on 16/10/14.
 */
public class RandomGenerator extends AbstractGenerator {

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "0123456789" +
            "&é\"'(-è_çà)=ù*^,;:!?./§~#{[|`\\^@]}]+*²<>%µ£¨";

    @Override
    protected int genInteger() {
        return new Random().nextInt();
    }

    @Override
    protected long genLong() {
        return new Random().nextLong();
    }     

    @Override
    protected double genDouble() {
        return new Random().nextDouble();
    }

    @Override
    protected float genFloat() {
        return new Random().nextFloat();
    }

    @Override
    protected char genCharacter() {
        return CHARACTERS.charAt(new Random().nextInt(CHARACTERS.length()));
    }

    @Override
    protected short genShort() {
        return (short) new Random().nextInt(Short.MAX_VALUE + 1);
    }

    @Override
    protected byte genByte() {
        byte[] bytes = new byte[1];
        new Random().nextBytes(bytes);
        return bytes[0];
    }

    @Override
    protected boolean genBoolean() {
        return new Random().nextBoolean();
    }

    @Override
    protected String genString() {
        int strLength = new Random().nextInt(100) + 1; // this is really arbitrary
        StringBuilder str = new StringBuilder();
        while (strLength > 0) {
            str.append(genCharacter());
            strLength--;
        }
        return str.toString();
    }
}
