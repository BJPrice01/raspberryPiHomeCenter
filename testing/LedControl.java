/**
*@author Brennan Price
*Created 09/28/2020
*
*/
import com.pi4j.io.gpio.*;
public class LedControl {
//Functions

//Classes

//////MAIN//////
  public static void main(String[] args){
    GpioController gpio = new GpioFactory.getInstance();
    GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", Pinstate.HIGH);
    pin.setShutdownOptions(true, PinState.LOW);
  }
}
