/**
*@author Brennan Price
*Created 09/28/2020
*Used to get the experience of controlling an led outside of the final product
*/
import com.pi4j.io.gpio.*;
public class LedControl {
//Functions

//Classes

//////MAIN//////
  public static void main(String[] args) throws InterruptedException{
    final GpioController gpio = GpioFactory.getInstance();
    final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22);
    pin.high();
    System.out.println("PinHigh");
    Thread.sleep(2000);
    pin.low();
    System.out.println("PinLow");
    Thread.sleep(2000);
    System.out.println("PinHigh for 2 seconds");
    pin.pulse(2000, true);
    gpio.shutdown();
  }
}