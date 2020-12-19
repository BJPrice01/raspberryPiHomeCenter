import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.util.ArrayList;

/**
 * menu to display lights
 */
public class LightPanel extends DrawingPanel {
    private ArrayList<Light> lights;
    private LightReader lr = new LightReader();
    private LightWriter lw = new LightWriter();

    /**
     * returns the lights
     * @return arraylist of lights
     */
    public ArrayList<Light> getLights(){
        return lights;
    }
    /**
     * sets the lights to an arraylist of lights
     * @param setLights light arraylist to set
     */
    public void setLights(ArrayList<Light> setLights) {
        lights = setLights;
    }
    /**
     * adds a light to the arraylist
     * @param light light to add
     * @return success or failure
     */
    public boolean addLight(Light light){
        lights.add(light);
        return lw.writeToBinary("lights.bin", lights);
    }
    /**
     * puts the buttons into a grid layout
     * add an extra buffer around the edges for a cleaner look
     * @param dimensions dimensions of the grid layout
     * @return success or failure
     */
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

    /**
     * paints the menu
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);        
    }
    /**
     * gets the dimensions of the menu for the grid layout
     * @param length length of the arraylist of lights
     * @return an int array with rows and columns
     */
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
    /**
     * constructs the light panel default
     */
    public LightPanel(){
        setLights(lr.readFromBinary("lights.bin"));
        int[] dimensions = getLayoutDimensions(lights.size());
        this.setLayout(new GridLayout(dimensions[0],dimensions[1]));
        displayLightButtons(dimensions);
    }
}
