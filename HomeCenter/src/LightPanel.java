import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.util.ArrayList;

public class LightPanel extends DrawingPanel {
    private ArrayList<Light> lights;
    private LightReader lr = new LightReader();
    private LightWriter lw = new LightWriter();

    public ArrayList<Light> getLights(){
        return lights;
    }

    public void setLights(ArrayList<Light> setLights) {
        lights = setLights;
    }

    public boolean addLight(Light light){
        lights.add(light);
        return lw.writeToBinary("lights.bin", lights);
    }

    public boolean displayLightButtons(){
        try{
            for(Light light: lights){
                JButton btnLight = new JButton(light.getName());
                btnLight.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        light.toggle();
                    }
                });
                this.add(btnLight);
            }
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);        
    }

    private int[] getLayoutDimensions(int length){
        int rows, columns;
        int[] dimensions;
        if(length % 5 == 0){
            columns = 5;
            rows = length/5;
        }else if(length % 4 == 0){
            columns = 4;
            rows = length/4;
        }else if(length % 3 == 0){
            columns = 3;
            rows = length/3;
        }else if(length % 2 == 0){
            columns = 2;
            rows = length/2;
        }else{
            columns = 1;
            rows = length/1;
        }
        dimensions = new int[2];
        dimensions[0] = rows;
        dimensions[1] = columns;
        return dimensions;
    }

    public LightPanel(){
        setLights(lr.readFromBinary("lights.bin"));
        int[] dimensions = getLayoutDimensions(lights.size());
        this.setLayout(new GridLayout(dimensions[0],dimensions[1]));
        displayLightButtons();
    }
}
