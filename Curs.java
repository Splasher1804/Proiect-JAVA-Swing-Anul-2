import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Curs implements OperatiiCurs {
    String nume;
    String descriere;
    Profesor profu;
    Student[] studenti;
    int[] note;

    public Curs(String nume, String descriere, Profesor profu, Student[] studenti) {
        this.nume = nume;
        this.descriere = descriere;
        this.profu = profu;
        this.studenti = studenti;
        this.note = new int[studenti.length];
    }

    public void UpdateProfesor(Profesor profu) {
        this.profu = profu;
    }

    public void AddStudent(Student student) {
        //lucrand cu array trebuie inserat folosind un sir auxiliar
        int noualungime = studenti.length + 1;
        Student[] aux = new Student[noualungime];
        int index = 0;
        for (Student s : studenti) {
            aux[index++] = s;
        }
        //la final adaugam noul student pe ultimul index
        aux[index] = student;
        //si realocam lista de studenti cu aux;
        this.studenti = new Student[noualungime];
        System.arraycopy(aux, 0, studenti, 0, noualungime);
    }

    @Override
    public void RemoveStudent(Student student) {
        int noualungime = studenti.length - 1;
        Student[] aux = new Student[noualungime];
        int index = 0;
        for (Student s : studenti) {
            if (s != student) {
                aux[index++] = s;
            }
        }
        this.studenti = new Student[noualungime];
        System.arraycopy(aux, 0, studenti, 0, noualungime);
    }




    @Override
    public void UpdateStudent(Student student) {
        for(int i=0; i<studenti.length; i++){
            if (studenti[i].getNume().equals((student.getNume())) && studenti[i].getPrenume().equals((student.getPrenume()))) {
                studenti[i] = student;
            }
        }
    }

    @Override
    public void UpdateCurs(String nume, String descriere) {
        this.nume = nume;
        this.descriere = descriere;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Curs: " + "nume=" + nume + ", descriere=" + descriere + ",\nprofu=" + profu + ",\nstudenti:\n");
        for (Student s : studenti) {
            str.append(s).append("\n");
        }
        return str.toString();
    }

    public String getNume() {
        return nume;
    }

    public Student[] getStudenti() {
        return studenti;
    }

    public void setStudenti(Student[] studenti) {
        this.studenti = studenti;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void noteazaStudent(Student studentNotat, int nota) {
        for ( int i = 0; i < studenti.length; i++) {
            Student student = studenti[i];
            if ( student.getNume().equals(studentNotat.getNume()) && student.getPrenume().equals(studentNotat.getPrenume())) {
                note[i] = nota;
            }
        }
    }

    public void raportStudentiInscrisi() {
        for (Student student : studenti) {
            System.out.println(student);
        }
    }

    public void raportNoteStudenti() {
        IntStream.range(0, studenti.length).mapToObj(i -> studenti[i] + " are nota " + note[i]).forEach(System.out::println);
    }

    public void raportMediaStudentilor() {
        int sum = Arrays.stream(note).sum();
        System.out.println("Media studentilor pentru cursul: " + nume + " este: " + sum/(double)note.length);
    }

    public Profesor getProfu() {
        return profu;
    }

    public boolean isEqual(Curs c) {
        return c.getNume().equals(nume);
    }

    //Adauga cursuri
    public static void AddCursuri(Curs curs) {
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("Cursuri.csv", true));
            PrintWriter printWriter = new PrintWriter(bw);
            printWriter.println(curs);
            printWriter.flush();
            printWriter.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Citeste cursuri
    public static void ReadCursuri() {

        try {
            File f = new File("Cursuri.csv");
            Scanner br = new Scanner(new FileReader(f));
            while (br.hasNextLine()) {
                String data = br.nextLine();
                System.out.println(data);
            }
            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}