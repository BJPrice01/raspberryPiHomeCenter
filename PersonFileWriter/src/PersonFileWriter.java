import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
/**
*@author Brennan Price
*writes people to a binary file
*/

public class PersonFileWriter{
//////MAIN//////
  public static void main(String[] args) throws IOException, UnknownHostException{
    
    PersonWriter pw = new PersonWriter();
    Person pBrennan = new Person("Brennan", "192.168.1.151");
    Person pJames = new Person("James", "192.168.1.152");
    Person pLisa = new Person("Lisa", "192.168.1.153");
    Person pMeghan = new Person("Meghan", "192.168.1.154");
    Person pReganne = new Person("Reganne", "192.168.1.155");

    ArrayList<Person> people = new ArrayList<Person>();
    people.add(pBrennan);
    people.add(pJames);
    people.add(pLisa);
    people.add(pMeghan);
    people.add(pReganne);

    pw.writeToBinary("people.bin", people);
    
    
    PersonReader pr = new PersonReader();
    ArrayList<Person> peopleRead = pr.readFromBinary("people.bin");
    for(Person person : peopleRead){
      System.out.println(person);
      System.out.println(person.getLocation());
    }
  }
}
