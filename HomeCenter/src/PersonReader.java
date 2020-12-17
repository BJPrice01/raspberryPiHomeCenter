import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class PersonReader {
    public ArrayList<Person> readFromBinary(String fname){
        File f = new File(fname);
        return readFromBinary(f);
    }
    public ArrayList<Person> readFromBinary(File f){
        try{
            ArrayList<Person> peopleRead;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            peopleRead = (ArrayList<Person>)ois.readObject();
            ois.close();
            return peopleRead;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }

    }
}
