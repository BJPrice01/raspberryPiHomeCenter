import java.util.ArrayList;
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

public class LightWriter {
    public boolean writeToBinary(String fname, ArrayList<Light> lights){
        File f = new File(fname);
        return writeToBinary(f, lights);

    }
    public boolean writeToBinary(File f, ArrayList<Light> lights){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(lights);
            oos.close();
            return true;
        }catch(Exception ex){
            return false;
        }
    }
}
