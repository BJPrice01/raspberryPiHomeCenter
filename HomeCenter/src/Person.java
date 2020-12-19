import java.io.IOException;
import java.net.UnknownHostException;
import java.net.InetAddress;
import java.io.Serializable;

public class Person implements Serializable{
    private String name, ipAddr, location;
    private boolean isHome;
    /**
     * sets the name of the person
     * @param name string name of person
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * sets the ip address of the person
     * @param ipAddr string ip addres of person
     */
    public void setIpAddr(String ipAddr){
        this.ipAddr = ipAddr;
    }
    /**
     * checks if the person is home, then sets locati0n and boolean
     * @throws IOException
     * @throws UnknownHostException
     */
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

    /**
     * gets the name of the person
     * @return persons name
     */
    public String getName(){
        return name;
    }
    /**
     * gets the ip address of the person
     * @return ip address
     */
    public String getIpAddr(){
        return ipAddr;
    }
    /**
     * gets if the person is back or not
     * @return boolean true if home
     */
    public boolean getIsHome(){
        return isHome;
    }
    /**
     * gets the location of the person
     * @return home or away
     */
    public String getLocation(){
        return location;
    }
    /**
     * default constructor of person
     * @throws IOException
     * @throws UnknownHostException
     */
    public Person() throws IOException, UnknownHostException{
        setName("Name");
        setIpAddr("192.168.1.0");
        setHome();
    }
    /**
     * constructor for a person
     * @param personName name of person
     * @param personIpAddr ip of person
     * @throws IOException
     * @throws UnknownHostException
     */
    public Person(String personName, String personIpAddr) throws IOException, UnknownHostException{
        setName(personName);
        setIpAddr(personIpAddr);
        setHome();
    }
    /**
     * writes name and ip address to a string
     */
    @Override
    public String toString(){
        return String.format("%s %s", name, ipAddr);
    }
}
