import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * frame for the program to display
 */
public class HomeFrame extends JFrame{
  private LightPanel lightPanel;
  private LocationPanel locationPanel;
  private BellPanel bellPanel;
  private MainPanel mainPanel;

  /**
   * sets the look of the frame
   * @param title title of window
   * @param width width of hte window
   * @param height height of the window
   * @param undecorated undecorated - true or decorated - false
   */
  public void setLook(String title, int width, int height, boolean undecorated){
    setTitle(title);
    setBounds(0,0,width, height);
    setUndecorated(undecorated);
    Container c = getContentPane();
    c.setLayout(new BorderLayout());
    JPanel subPanel = new JPanel();
    subPanel.setLayout(new GridLayout(4,1));
    JButton btnLights = new JButton("Lights");
    btnLights.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        displayLightMenu(c);
      }
    });
    JButton btnLocation = new JButton("Location");
    btnLocation.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        displayLocationMenu(c);
      }
    });
    JButton btnBell = new JButton("Bell");
    btnBell.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        displayBellMenu(c);
      }
    });
    JButton btnMain = new JButton("Main");
    btnMain.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        displayMainMenu(c);
      }
    });
    subPanel.add(btnLights);
    subPanel.add(btnLocation);
    subPanel.add(btnBell);
    subPanel.add(btnMain);
    c.add(subPanel, BorderLayout.WEST);
    displayMainMenu(c);
    }
    /**
     * clears the main panel for a new one to be displayed
     * @param c the fram container
     */
    private void clearCenterPanel(Container c){
      try{
        BorderLayout layout = (BorderLayout)c.getLayout();
        remove(layout.getLayoutComponent(BorderLayout.CENTER));
      }catch(Exception ex){}
    }
    /**
     * displays menu for lights
     * @param c the frame container
     */
    public void displayLightMenu(Container c){
      clearCenterPanel(c);
      LightPanel lightPanel = new LightPanel();
      c.add(lightPanel, BorderLayout.CENTER);
      setVisible(true);
    }
    /**
     * displays the menu for location
     * @param c the frame container
     */
    public void displayLocationMenu(Container c){
      clearCenterPanel(c);
      LocationPanel locationPanel = new LocationPanel();
      c.add(locationPanel, BorderLayout.CENTER);
      setVisible(true);
    }
    /**
     * displays the menu for the bell
     * @param c the frame container
     */
    public void displayBellMenu(Container c){
      clearCenterPanel(c);
      BellPanel bellPanel = new BellPanel();
      c.add(bellPanel, BorderLayout.CENTER);
      setVisible(true);
    }
    /**
     * displays the main menu
     * @param c the frame container
     */
    public void displayMainMenu(Container c){
      clearCenterPanel(c);
      MainPanel mainPanel = new MainPanel();
      c.add(mainPanel, BorderLayout.CENTER);
      setVisible(true);
    }


    /**
     * the default constructor, set for resolution of the rasberry pi screen
     */
    public HomeFrame(){
      setLook("Home Center", 1024, 600, true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    /**
     * custom constructor
     * @param title title of window
     * @param width width of window
     * @param height height of window
     * @param undecorated decorated or not
     * @param close default close
     */
    public HomeFrame(String title, int width, int height, boolean undecorated, int close){
      setLook(title, width, height, undecorated);
      setDefaultCloseOperation(close);
    }
 }