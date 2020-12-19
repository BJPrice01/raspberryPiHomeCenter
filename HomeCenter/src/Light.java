import java.io.Serializable;
import java.io.InputStream;
import java.util.Scanner;
/**
 * Stores information and commands for light object
 */
public class Light implements Serializable{
    private String name, ipAddress, port, cmd, status;
    private String[] env = {"PATH=/bin:/usr/bin/"};
    private Process pr;
    /**
     * sets the name
     * @param lightName name of the light
     */
    public void setName(String lightName){
        name = lightName;
    }
    /**
     * returns the name of the light
     * @return string name of light
     */
    public String getName(){
        return name;
    }
    /**
     * sets the ip address of the light
     * @param ip string ip address
     */
    public void setipAddress(String ip){
        ipAddress = ip;
    }
    /**
     * sets the port that listens on the network, 9999 is the standard on my model
     * @param lightPort
     */
    public void setPort(String lightPort){
        port = lightPort;
    }
    /**
     * turns the light on
     */
    public void turnOn(){
        try{
            cmd = "./hs100.sh " + ipAddress + " " + port + " on";
            pr = Runtime.getRuntime().exec(cmd,env);
        }catch(Exception e){}
    }
    /**
     * turns the light off
     */
    public void turnOff(){
        try{
            cmd = "./hs100.sh " + ipAddress + " " + port + " off";
            pr = Runtime.getRuntime().exec(cmd,env);
        }catch(Exception e){}
    }
    /**
     * toggles the light on or off depending on current state
     */
    public void toggle(){
        try{
            cmd = "./hs100.sh " + ipAddress + " " + port + " toggle";
            System.out.println(cmd);
            pr = Runtime.getRuntime().exec(cmd,env);
        }catch(Exception ex){
            System.out.println("Failed");
        }
    }
    /**
     * gets the lights current state
     * @return on or off
     */
    public String getStatus(){
        try{
            cmd = "./hs100.sh " + ipAddress + " " + port + " check";
            pr = Runtime.getRuntime().exec(cmd,env);
            InputStream is = pr.getInputStream();
            Scanner sc = new Scanner(is);
            status = sc.nextLine();
            sc.close();
        }catch(Exception ex){
        }
        return status;
    }
    /**
     * default constructor
     */
    public Light(){
        setName("Default");
    }
    /**
     * full constructor
     * @param lightName name of hte light
     * @param lightIp ip address of hte light
     * @param lightPort port of hte light
     */
    public Light(String lightName, String lightIp, String lightPort){
        setName(lightName);
        setipAddress(lightIp);
        setPort(lightPort);
    }
    /**
     * returns string with name, ip and port
     */
    @Override
    public String toString(){
        return String.format("%s, %s, %s", name, ipAddress, port);
    }
}
