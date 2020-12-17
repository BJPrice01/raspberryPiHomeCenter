import java.util.ArrayList;
/**
*@author Brennan Price
*Raspi Home Center to contol lights throughout the house, among other things
*/

public class LightFileWriter {
//////MAIN//////
  public static void main(String[] args){
  LightWriter lw = new LightWriter();
  Light brnLight = new Light("Brennan", "192.168.1.201", "9999");
  Light othrLight = new Light("Snake Heat", "192.168.1.202", "9999");
  ArrayList<Light> lights = new ArrayList<Light>();
  lights.add(brnLight);
  lights.add(othrLight);
  lw.writeToBinary("lights.bin", lights);
  }
}
