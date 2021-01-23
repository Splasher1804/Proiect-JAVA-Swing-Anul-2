import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class CitireRun implements Runnable{
    @Override
    public void run() {

        try {
            File f = new File("Studenti.csv");
            Scanner s = new Scanner(new FileReader(f));
            while (s.hasNextLine()) {
                String data = s.nextLine();
                System.out.println(data);
            }
            s.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println ("Firul de executie pentru citire este terminat.");
    }
}
