import java.util.ArrayList;
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

/**
 * writes an arraylist of lights to binary
 */
public class LightWriter {
    /**
     * writes an arraylist to binary
     * @param fname name of file
     * @param lights arraylist of lights to save
     * @return success or failure
     */
    public boolean writeToBinary(String fname, ArrayList<Light> lights){
        File f = new File(fname);
        return writeToBinary(f, lights);

    }
    /**
     * writes an arraylist to binary
     * @param f file object
     * @param lights arraylist of lights to save
     * @return success or failure
     */
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
