import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.swing.ImageIcon;


public class Main {

    public static void main (String []args) throws InterruptedException {

        Student[] studenti = new Student[]{new Student("Andrei","Negoita",2231)};
        Profesor prof = new Profesor("Anton","Panaitescu");
        Curs curs = new Curs("Rezistenta Materialelor", "calculul reacţiunilor,diagramele de eforturi, " +
                "calculul caracteristicilor geometrice ale suprafeţelor plane şi calculul elementelor de rezistenţă la solicitări simple", prof, studenti);


        Frame MyFrame = new Frame();

        ScriereRun Scriere_Runnable = new ScriereRun();
        Thread Scriere = new Thread(Scriere_Runnable);

        ScriereRun2 Scriere_Runnable2 = new ScriereRun2();
        Thread Scriere2 = new Thread(Scriere_Runnable2);

        CitireRun Citire_Runnable = new CitireRun();
        Thread Citire = new Thread(Citire_Runnable);

        Scriere.start();
        Scriere.join();
        Scriere2.start();
        Scriere2.join();
        Citire.start();

        Curs.AddCursuri(curs);
        Curs.ReadCursuri();

        Profesor.AddProfesori(prof);
        Profesor.ReadProfesori();

        Student.AddStudenti(studenti[0]);
        Student.ReadStudenti();

    }
}
