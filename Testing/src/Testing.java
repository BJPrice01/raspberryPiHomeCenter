/**
*@author Brennan Price
*Created 10/21/2020
*
*/

//import com.pi4j.io.gpio.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Scanner;
import java.net.*;
import java.util.Enumeration;
import java.util.Collections;
import java.io.File;
import javax.sound.sampled.*;

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

public static void runLightCommand(){
    String cmdOn = "./Testing/hs100.sh 192.168.1.3 9999 on";
    String cmdOff = "./Testing/hs100.sh 192.168.1.3 9999 off";
    String cmdCheck = "./hs100.sh 192.168.1.3 9999 check";

    String[] env = {"PATH=/bin:/usr/bin/"};
    try{
      Process pr = Runtime.getRuntime().exec(cmdCheck, env);
      InputStream is = pr.getInputStream();
      Scanner sc = new Scanner(is);
      System.out.println(sc.nextLine());
    }catch(Exception ex){
      ex.printStackTrace();
    }
}

public static boolean pingAddress(String addr) throws IOException, UnknownHostException{
  InetAddress inetAddr = InetAddress.getByName(addr);
  return inetAddr.isReachable(3000);
}
*/

//////MAIN//////
  public static void main(String[] args){
    //blink();
    //runLightCommand();
    //boolean reached = pingAddress("192.168.1.12");
    //System.out.println(reached);
    Clip clip;
    try{
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("dinnerBell.wav"));
      clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.setFramePosition(0);
      clip.start();
      clip.loop(Clip.LOOP_CONTINUOUSLY);
    }catch(Exception ex){
      ex.printStackTrace();
    }
  }
}