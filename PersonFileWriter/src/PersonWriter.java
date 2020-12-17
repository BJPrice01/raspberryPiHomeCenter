import java.util.ArrayList;
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

public class PersonWriter {
    public boolean writeToBinary(String fname, ArrayList<Person> people){
        File f = new File(fname);
        return writeToBinary(f, people);

    }
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
