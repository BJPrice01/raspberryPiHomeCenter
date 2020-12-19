import java.util.ArrayList;
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

/**
 * writes people to a binary file
 */
public class PersonWriter {
    /**
     * writes people to a file
     * @param fname name of the file
     * @param people people to write
     * @return success or failure
     */
    public boolean writeToBinary(String fname, ArrayList<Person> people){
        File f = new File(fname);
        return writeToBinary(f, people);

    }
    /**
     * writes people to a file
     * @param f name of the file
     * @param people people to write
     * @return success or failure
     */
    public boolean writeToBinary(File f, ArrayList<Person> people){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(people);
            oos.close();
            return true;
        }catch(Exception ex){
            return false;
        }
    }
}
