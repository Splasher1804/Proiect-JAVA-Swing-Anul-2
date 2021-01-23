import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditareStudenti extends Main implements ActionListener {
    JButton button = new JButton();
    JButton button2 = new JButton();
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JTextField textFieldNume = new JTextField();
    JTextField textFieldPrenume = new JTextField();
    JTextField textFieldGrupa = new JTextField();


    EditareStudenti() {
        ImageIcon icon = new ImageIcon("Tree.png");
        frame.setIconImage(icon.getImage());
        Border border = BorderFactory.createLineBorder(Color.BLACK);


        label.setText("Adaugare Studenti");
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
        label.setBounds(0, 0, 500, 50);

        //Student student = new Student(nume, prenume, num);

        textFieldNume.setPreferredSize(new Dimension(200,50));
        textFieldNume.setForeground(Color.BLUE);
        textFieldNume.setText("Nume");

        textFieldPrenume.setPreferredSize(new Dimension(200,50));
        textFieldPrenume.setForeground(Color.BLUE);
        textFieldPrenume.setText("Prenume");

        textFieldGrupa.setPreferredSize(new Dimension(200,50));
        textFieldGrupa.setForeground(Color.BLUE);
        textFieldGrupa.setText("Grupa(doar cifre)");

        button.setBounds(50, 400, 150, 50 );
        button.addActionListener(this);
        button.setText("Inapoi");
        button.setFocusable(false);
        button.setIconTextGap(-15);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFont(new Font("Comic Sans", Font.BOLD,25));
        button.setForeground(new Color(236, 248, 246, 200));
        button.setBackground(new Color(245, 166, 234, 255));
        button.setBorder(BorderFactory.createEtchedBorder());

        button2.setBounds(50, 150, 400, 50);
        button2.addActionListener(this);
        button2.setText("Submit");
        button2.setFocusable(false);
        button2.setIconTextGap(-15);
        button2.setHorizontalTextPosition(JButton.CENTER);
        button2.setVerticalTextPosition(JButton.BOTTOM);
        button2.setFont(new Font("Comic Sans", Font.BOLD, 25));
        button2.setForeground(new Color(236, 248, 246, 200));
        button2.setBackground(new Color(245, 166, 234, 255));
        button2.setBorder(BorderFactory.createEtchedBorder());



        frame.setTitle("Adaugati Studenti");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        frame.setResizable(false);//prevent this from being resized
        frame.setSize(500, 500);//set dimensions x and y
        frame.setVisible(true);//make this visible
        frame.getContentPane().setBackground(new Color(90, 243, 189, 72));
        frame.add(label);
        frame.add(button);
        frame.add(textFieldNume);
        frame.add(textFieldPrenume);
        frame.add(textFieldGrupa);
        frame.add(button2);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button2) {
            String nume = textFieldNume.getText();
            String prenume = textFieldPrenume.getText();
            String grupaString = textFieldGrupa.getText();
            Integer num = Integer.valueOf(grupaString);
            Student student = new Student(nume, prenume, num);
            Student.AddStudenti(student);
            textFieldNume.setText("");
            textFieldPrenume.setText("");
            textFieldGrupa.setText("");
            System.out.println("Student adaugat! " +textFieldNume.getText());
        }
        if (e.getSource() == button) {
            frame.dispose();
            Frame meniuS = new Frame();
        }

    }
}