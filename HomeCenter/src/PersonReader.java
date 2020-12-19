import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * reads a list of people from a binary file
 */
public class PersonReader {
    /**
     * reads people from a file
     * @param fname name of file
     * @return arraylist of people
     */
    public ArrayList<Person> readFromBinary(String fname){
        File f = new File(fname);
        return readFromBinary(f);
    }
    /**
     * reads people from a file
     * @param f file object
     * @return arraylist of people
     */
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
