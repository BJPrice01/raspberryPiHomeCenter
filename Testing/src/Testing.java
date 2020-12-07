/**
*@author Brennan Price
*Created 10/21/2020
*
*/

//import com.pi4j.io.gpio.*;

public class Testing {
  /*
//Functions
public static void blink() throws InterruptedException{
  GpioController gpio = GpioFactory.getInstance();
  GpioPinDigitalOutput outPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01,"MyLED", PinState.HIGH);
  System.out.println("Pin should be on.");
  outPin.setShutdownOptions(true, PinState.LOW);
  Thread.sleep(5000);
  outPin.low();
  System.out.println("Pin should be off.");
  Thread.sleep(5000);
  outPin.toggle();
  System.out.println("Pin should be on.");
  Thread.sleep(5000);
  outPin.toggle();
  System.out.println("Pin should be off.");
  Thread.sleep(5000);
  outPin.pulse(1000);
  gpio.shutdown();
  System.out.println("END");
}
*/
//////MAIN//////
  public static void main(String[] args){
    //blink();
    String cmdOn = "/home/n3rd/Dropbox/schoolWork/semester3/oborpro/raspberryPiHomeCenter/Testing/hs100.sh 192.168.1.3 9999 on";
    String cmdOff = "/home/n3rd/Dropbox/schoolWork/semester3/oborpro/raspberryPiHomeCenter/Testing/hs100.sh 192.168.1.3 9999 off";
    String[] env = {"PATH=/bin:/usr/bin/"};
    try{
      Process pr = Runtime.getRuntime().exec(cmdOn, env);
    }catch(Exception ex){
      ex.printStackTrace();
    }
  }
}
