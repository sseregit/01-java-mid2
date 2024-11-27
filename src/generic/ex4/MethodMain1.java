package generic.ex4;

public class MethodMain1 {

    public static void main(String[] args) {
        Integer i = 10;

        Object i1 = GenericMethod.objMethod(i);

        Integer result = GenericMethod.<Integer>genericMethod(i);
        Integer integerValue = GenericMethod.<Integer>numberMethod(i);
        Double doubleValue = GenericMethod.<Double>numberMethod(3.14);

        Integer result1 = GenericMethod.genericMethod(i);
        Integer integerValue1 = GenericMethod.numberMethod(i);
        Double doubleValue1 = GenericMethod.numberMethod(3.14);

    }
}
