/**
*@author Brennan Price
*Created 09/28/2020
*Used to get the experience of controlling an led outside of the final product
*/
import java.lang.Runtime;
public class LedControl {
//Functions
public static void ledSetup(){
  
}

//////MAIN//////
  public static void main(String[] args) throws InterruptedException{
    Runtime run = new Runtime();
    run.exec("python lightOn.py");
  }
}