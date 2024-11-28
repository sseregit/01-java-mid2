package generic.test.ex3;

import generic.test.ex3.unit.BioUnit;

public class UnitUtil {

    public static <U extends BioUnit> U maxHp(U u1, U u2) {

        if (u1.getHp() >= u2.getHp()) {
            return u1;
        }

        return u2;
    }
}
