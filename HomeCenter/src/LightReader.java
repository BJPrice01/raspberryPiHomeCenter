import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * reads the lights from a binary file
 */
public class LightReader {
    /**
     * reads an arraylist by an fname
     * @param fname name of file
     * @return arraylist of lights if succeed, null if fail
     */
    public ArrayList<Light> readFromBinary(String fname){
        File f = new File(fname);
        return readFromBinary(f);
    }
    /**
     * reads an arraylist from a file
     * @param f file object
     * @return arraylist of lights if succeed, null if fail
     */
    public ArrayList<Light> readFromBinary(File f){
        try{
            ArrayList<Light> lightsRead;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            lightsRead = (ArrayList<Light>)ois.readObject();
            ois.close();
            return lightsRead;
        }catch(Exception ex){
            return null;
        }

    }
}
