import java.util.ArrayList;
/**
*@author Brennan Price
*Raspi Home Center to contol lights throughout the house, among other things
*/

public class LightFileWriter {
//////MAIN//////
  public static void main(String[] args){
  LightWriter lw = new LightWriter();
  Light brnLight = new Light("Brennan", "192.168.1.4", "9999");
  Light othrLight = new Light("Other", "192.168.1.100", "9999");
  ArrayList<Light> lights = new ArrayList<Light>();
  lights.add(brnLight);
  lights.add(othrLight);
  lw.writeToBinary("lights.bin", lights);
  }
}
