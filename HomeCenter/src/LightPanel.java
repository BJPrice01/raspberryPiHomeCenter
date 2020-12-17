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

    public boolean displayLightButtons(int[] dimensions){
        try{
            int lightCount = 0;
            int rows = dimensions[0];
            int columns = dimensions[1];
            int cells = rows*columns;
            for(int i = 1; i <= cells; i++){
                if(i < columns || i > cells - columns){
                    this.add(new DrawingPanel());
                } else if(i % columns == 1 || i % columns == 0){
                    this.add(new DrawingPanel());
                }else{
                    Light light = lights.get(lightCount);
                    lightCount = lightCount + 1;
                    JButton btnLight = new JButton(light.getName());
                    btnLight.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            light.toggle();
                        }
                    });
                    this.add(btnLight);
                }
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
            columns = 5 + 2;
            rows = length/5 + 2;
        }else if(length % 4 == 0){
            columns = 4 + 2;
            rows = length/4 + 2;
        }else if(length % 3 == 0){
            columns = 3 + 2;
            rows = length/3 + 2;
        }else if(length % 2 == 0){
            columns = 2 + 2;
            rows = length/2 + 2;
        }else{
            columns = 1 + 2;
            rows = length/1 + 2;
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
        displayLightButtons(dimensions);
    }
}
