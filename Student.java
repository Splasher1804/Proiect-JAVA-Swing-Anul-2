import java.io.*;
import java.util.Scanner;

public class Student extends Persoana {
    int grupa;

    public Student(String nume, String prenume, int grupa) {
        this.nume = nume;
        this.prenume = prenume;
        this.grupa = grupa;
    }

    @Override
    public String toString() {
        return "Student{" + "nume=" + nume + ", prenume=" + prenume + ", grupa=" + grupa + '}';
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getGrupa() {
        return grupa;
    }

    public void setGrupa(int grupa) {
        this.grupa = grupa;
    }
    public static void AddStudenti(Student studenti) {

        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("Studenti.csv", true));
            PrintWriter printWriter = new PrintWriter(bw);
            printWriter.println(studenti);
            printWriter.flush();
            printWriter.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

        public static String ReadStudenti() {
            try {
                File f = new File("Studenti.csv");
                Scanner s = new Scanner(new FileReader(f));
                while (s.hasNextLine()) {
                    String data = s.nextLine();
                    System.out.println(data);
                }
                s.close();
            } catch (Exception ex) {
                System.out.println("Eroare");
                ex.printStackTrace();
            }
            return "";
        }

    }

