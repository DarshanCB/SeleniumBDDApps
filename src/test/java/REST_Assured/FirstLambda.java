package REST_Assured;

import java.util.function.Supplier;

public class FirstLambda {
    public static void main(String[] args)
    {
            Supplier<String> supplier = () -> "Hello!";

            String string = supplier.get();

            System.out.println(string);
    }

}
