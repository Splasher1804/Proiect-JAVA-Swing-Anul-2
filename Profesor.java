import java.io.*;
import java.util.Scanner;

public class Profesor {

    String nume;
    String prenume;

    @Override
    public String toString() {
        return "Profesor{" + "nume=" + nume + ", prenume=" + prenume + '}';
    }

    public Profesor(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }

    //Scriere Fisier Profesori.csv
    public static void AddProfesori(Profesor prof) {
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("Profesori.csv", true));
            PrintWriter printWriter = new PrintWriter(bw);
            printWriter.println(prof);
            printWriter.flush();
            printWriter.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Citire Fisier Profesori.csv
    public static String ReadProfesori() {
        try {
            File f = new File("Profesori.csv");
            Scanner br = new Scanner(new FileReader(f));
            while (br.hasNextLine()) {
                String data = br.nextLine();
                System.out.println(data);
            }
            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
}

