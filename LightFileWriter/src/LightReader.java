import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LightReader {
    public ArrayList<Light> readFromBinary(String fname){
        File f = new File(fname);
        return readFromBinary(f);
    }
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
