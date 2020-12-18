import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.font.*;

public class LocationPanel extends DrawingPanel{
    private ArrayList<Person> people;

    public ArrayList<Person> readPeople(String fname){
        PersonReader pr = new PersonReader();
        return pr.readFromBinary(fname);
    }

    public void listPeople(ArrayList<Person> people){
        try{
            JLabel name;
            JLabel isHome;
            for(Person person: people){
                name = new JLabel(person.getName());
                isHome = new JLabel(person.getLocation());
                this.add(name);
                this.add(isHome);
            }

            
        }catch(Exception ex){}
    }

    public LocationPanel(){
        people = readPeople("people.bin");
        setLayout(new GridLayout(people.size(),2));
        listPeople(people);
    }
    
}
