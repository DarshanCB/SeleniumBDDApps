package BaseClass;

import org.testng.annotations.DataProvider;

public class DataProviderTestClass {

    @DataProvider
    public static Object[][] myInputProvider() {
        return new Object[][] {
                {"charles.morris@reqres.in"},
                {"george.bluth@reqres.in"},
                {"emma.wong@reqres.in"}
        };
    }
}
