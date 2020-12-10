import java.io.Serializable;
import java.io.InputStream;
import java.util.Scanner;
/**
 * 
 */
public class Light implements Serializable{
    private String name, ipAddress, port, cmd, status;
    private String[] env = {"PATH=/bin:/usr/bin/"};
    private Process pr;

    public void setName(String lightName){
        name = lightName;
    }
    public String getName(){
        return name;
    }
    public void setipAddress(String ip){
        ipAddress = ip;
    }
    public void setPort(String lightPort){
        port = lightPort;
    }

    public void turnOn(){
        try{
            cmd = "./hs100.sh " + ipAddress + " " + port + " on";
            pr = Runtime.getRuntime().exec(cmd,env);
        }catch(Exception e){}
    }

    public void turnOff(){
        try{
            cmd = "./hs100.sh " + ipAddress + " " + port + " off";
            pr = Runtime.getRuntime().exec(cmd,env);
        }catch(Exception e){}
    }

    public void toggle(){
        try{
            cmd = "./hs100.sh " + ipAddress + " " + port + " toggle";
            System.out.println(cmd);
            pr = Runtime.getRuntime().exec(cmd,env);
        }catch(Exception ex){
            System.out.println("Failed");
        }
    }

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

    public Light(){
        setName("Default");
    }
    public Light(String lightName, String lightIp, String lightPort){
        setName(lightName);
        setipAddress(lightIp);
        setPort(lightPort);
    }
    @Override
    public String toString(){
        return String.format("%s, %s, %s", name, ipAddress, port);
    }
}
