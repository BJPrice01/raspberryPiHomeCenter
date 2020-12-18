import java.io.File;
import java.io.IOException;
import java.awt.GridLayout;
import javax.sound.sampled.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BellPanel extends DrawingPanel{
    public void playDinnerBell(){
        Clip clip;
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("dinnerBell.wav"));
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.setFramePosition(0);
            clip.start();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void setButton(){
        for(int i = 0; i < 9; i++){
            if(i == 4){
                JButton btnSound = new JButton("Bell");
                btnSound.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        playDinnerBell();
                    }
                });
                this.add(btnSound);
            }else{
                this.add(new DrawingPanel());
            }
        }
    }

    public BellPanel(){
        setLayout(new GridLayout(3,3));
        setButton();
    }
    
}
