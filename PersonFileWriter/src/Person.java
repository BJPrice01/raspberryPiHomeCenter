import java.io.IOException;
import java.net.UnknownHostException;
import java.net.InetAddress;
import java.io.Serializable;

public class Person implements Serializable{
    private String name, ipAddr, location;
    private boolean isHome;
    
    public void setName(String name) {
        this.name = name;
    }
    public void setIpAddr(String ipAddr){
        this.ipAddr = ipAddr;
    }
    public void setHome()throws IOException, UnknownHostException{
        boolean checkIsHome = false;
        InetAddress inetAddr = InetAddress.getByName(ipAddr);
        checkIsHome = inetAddr.isReachable(3500);
        isHome = checkIsHome;
        if(checkIsHome){
            location = "home";
        }else{
            location = "away";
        }
    }

    public String getName(){
        return name;
    }
    public String getIpAddr(){
        return ipAddr;
    }
    public boolean getIsHome(){
        return isHome;
    }
    public String getLocation(){
        return location;
    }

    public Person() throws IOException, UnknownHostException{
        setName("Name");
        setIpAddr("192.168.1.0");
        setHome();
    }
    public Person(String personName, String personIpAddr) throws IOException, UnknownHostException{
        setName(personName);
        setIpAddr(personIpAddr);
        setHome();
    }
    @Override
    public String toString(){
        return String.format("%s %s", name, ipAddr);
    }
}
