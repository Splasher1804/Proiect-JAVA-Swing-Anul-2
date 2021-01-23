import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ScriereRun implements Runnable {
    @Override
    public void run() {
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("Studenti.csv", true));
            PrintWriter printWriter = new PrintWriter(bw);
            printWriter.println("Miu Mihai2, 4LF791");
            printWriter.flush();
            printWriter.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println ("Firul de executie pentru scriere este terminat.");

    }
}
