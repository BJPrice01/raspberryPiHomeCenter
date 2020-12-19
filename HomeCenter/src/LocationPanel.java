import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridLayout;

/**
 * displays the menu of location information
 */
public class LocationPanel extends DrawingPanel{
    private ArrayList<Person> people;
    /**
     * gets the arraylist of people from a file
     * @param fname name of file to read from
     * @return arraylist of people
     */
    public ArrayList<Person> readPeople(String fname){
        PersonReader pr = new PersonReader();
        return pr.readFromBinary(fname);
    }
    /**
     * wries all the people to the screen
     * @param people arraylist of people to show
     */
    public void listPeople(ArrayList<Person> people){
        try{
            JLabel name;
            JLabel isHome;
            for(Person person: people){
                name = new JLabel(person.getName().toUpperCase());
                isHome = new JLabel(person.getLocation().toUpperCase());
                name.setHorizontalAlignment(JLabel.CENTER);
                name.setForeground(Color.BLACK);
                name.setSize(20,20);
                isHome.setHorizontalAlignment(JLabel.CENTER);
                isHome.setForeground(Color.BLACK);
                isHome.setOpaque(true);
                isHome.setBackground(Color.RED);
                if(isHome.getText().equalsIgnoreCase("home")){
                    isHome.setBackground(Color.GREEN);
                }
                this.add(name);
                this.add(isHome);
                name.setBorder(BorderFactory.createMatteBorder(1, 2, 1, 1, Color.BLACK));
                isHome.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 2, Color.BLACK));
            }
        }catch(Exception ex){}
    }
    public LocationPanel(){
        people = readPeople("people.bin");
        setLayout(new GridLayout(people.size(),2));
        listPeople(people);
    }
}
