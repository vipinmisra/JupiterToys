package framework.lib;

public class HelperMethods {

    public static void sleep(int seconds)  {
        try {
            Thread.sleep(seconds * 1000);
        }
        catch( InterruptedException e){}
    }
}
