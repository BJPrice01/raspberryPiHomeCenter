/**
*@author Brennan Price
*Created 09/28/2020
*Used to get the experience of controlling an led outside of the final product
*/
import java.io.IOException;
public class LedControl {
//Functions
public static void ledSetup(){
  
}

//////MAIN//////
  public static void main(String[] args) throws IOException, InterruptedException{
    Runtime run = Runtime.getRuntime();
    run.exec("python lightOn.py");
    Thread.sleep(1000);
    run.exec("python lightOff.py");
  }
}