import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MeniuStudenti implements ActionListener {
    JButton button = new JButton();
    JButton button2 = new JButton();
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    MeniuStudenti(){
        ImageIcon icon= new ImageIcon("Tree.png");
        frame.setIconImage(icon.getImage());
        Border border = BorderFactory.createLineBorder(Color.BLACK);


        label.setText("Meniu Studenti");
        label.setHorizontalTextPosition(JLabel.CENTER);// set text left, center or right image icon
        label.setVerticalTextPosition(JLabel.TOP);// set text top, centet or bottom of image icon
        label.setForeground(Color.BLUE);//set font color of text
        label.setFont((new Font("MV Boli", Font.PLAIN, 20))); //set font of text
        label.setIconTextGap(-10);//set gap of text to image
        label.setBackground(Color.GREEN);
        label.setOpaque((true));
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(0,0,500,50);


        button.setBounds(50, 100, 400, 50 );
        button.addActionListener(this);
        button.setText("Vizualizare Studenti");
        button.setFocusable(false);
        button.setIconTextGap(-15);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFont(new Font("Comic Sans", Font.BOLD,25));
        button.setForeground(new Color(236, 248, 246, 200));
        button.setBackground(new Color(245, 166, 234, 255));
        button.setBorder(BorderFactory.createEtchedBorder());

        button2.setBounds(50, 175, 400, 50 );
        button2.addActionListener(this);
        button2.setText("Editare Studenti");
        button2.setFocusable(false);
        button2.setIconTextGap(-15);
        button2.setHorizontalTextPosition(JButton.CENTER);
        button2.setVerticalTextPosition(JButton.BOTTOM);
        button2.setFont(new Font("Comic Sans", Font.BOLD,25));
        button2.setForeground(new Color(236, 248, 246, 200));
        button2.setBackground(new Color(245, 166, 234, 255));
        button2.setBorder(BorderFactory.createEtchedBorder());

        frame.setTitle("Meniu Studenti");
        frame.setLayout(null);
        frame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        frame.setResizable(false);//prevent this from being resized
        frame.setSize(500,500);//set dimensions x and y
        frame.setVisible(true);//make this visible
        frame.getContentPane().setBackground(new Color(90, 243, 189, 72));
        frame.add(label);
        frame.add(button);
        frame.add(button2);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            frame.dispose();
            VizualizareStudenti meniuS = new VizualizareStudenti();
        }
        if(e.getSource()==button2){
            frame.dispose();
            EditareStudenti meniuS2 = new EditareStudenti();
        }
    }

}
