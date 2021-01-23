import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class VizualizareCursuri extends Main implements ActionListener  {
    JButton button = new JButton();
    JTextArea ACursuri = new JTextArea();
    JScrollPane Scroll = new JScrollPane(ACursuri);
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    VizualizareCursuri(){
        ImageIcon icon= new ImageIcon("Tree.png");
        frame.setIconImage(icon.getImage());
        Border border = BorderFactory.createLineBorder(Color.BLACK);

        ACursuri.setBounds(50,70,400,300);
        ACursuri.setBorder(border);
        ACursuri.setLineWrap(true);
        ACursuri.setWrapStyleWord(true);
        ACursuri.setBackground(Color.CYAN);
        ACursuri.setForeground(Color.MAGENTA);
        ACursuri.setFont(new Font("Comic Sans", Font.ITALIC,16));
        ACursuri.setEditable(false);
        //Reading and displaying on JFrame
        ACursuri.setText("");
        String fileResult = "";
        try {

            BufferedReader csvReader = new BufferedReader(new FileReader("Cursuri.csv"));
            String line = null;
            while ((line = csvReader.readLine()) != null) {
                fileResult = fileResult + "\n" + line;
            }
        }catch (FileNotFoundException ex){
            System.err.println("File not found");
        }catch (IOException ioe){
            System.err.println("There was an error while reading the file");
        } ACursuri.setText(fileResult);

        Scroll.setPreferredSize(new Dimension(400,300));
        Scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        label.setText("Tabel Cursuri");
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

        frame.setTitle("Tabel Cursuri");
        frame.setLayout(null);
        frame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        frame.setResizable(false);//prevent this from being resized
        frame.setSize(500,500);//set dimensions x and y
        frame.setVisible(true);//make this visible
        frame.getContentPane().setBackground(new Color(90, 243, 189, 72));
        frame.add(label);
        frame.add(button);
        frame.add(ACursuri);
        frame.add(Scroll);
        frame.setLocationRelativeTo(null);


    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            frame.dispose();
            Frame meniuS = new Frame();
        }
    }

}