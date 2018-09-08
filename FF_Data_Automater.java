import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

//import javax.lang.model.util.Elements;
//import javax.swing.text.Document;
//import javax.swing.text.Element;

public class FF_Data_Automater {

    public void inputOutputData() {
        // importing (txt file) and exporting (txt file) data
        File txtFile = new File("D:\\Fantasy Football\\Analytics\\2018\\Cousins\\Season\\Data" +
                "\\Week.txt");
        try {
            Scanner txtScanner = new Scanner(txtFile);
            try {
                PrintStream ps2 = new PrintStream("D:\\Fantasy Football\\Analytics\\2018\\Cousins" +
                        "\\Season" +
                        "\\Data\\Week_output.txt");

                // getting input from txt file
                int week = txtScanner.nextInt();
                ps2.println("Week: " + week);
                ps2.println();
                // scores and records for each team
                double score, skip;
                int wins, losses, ties;
                String team, record;
                try {
                    for (int i = 1; i < 12; i++) {

                        // odd teams
                        if (i % 2 != 0) {
                            score = txtScanner.nextDouble();
                            // skip projected score
                            skip = txtScanner.nextDouble();
                            txtScanner.nextLine();
                            team = txtScanner.nextLine();
                            ps2.println("Team: " + team);
                            ps2.println("Score: " + score);
                            record = txtScanner.nextLine();
                            ps2.println("Record: " + record);
                            ps2.println();
                            continue;
                        }

                        // even teams
                        if (i % 2 == 0) {
                            // skip logo
                            txtScanner.nextLine();
                            score = txtScanner.nextDouble();
                            // skip projected score
                            skip = txtScanner.nextDouble();
                            // skip logo
                            txtScanner.nextLine();
                            txtScanner.nextLine();
                            team = txtScanner.nextLine();
                            ps2.println("Team: " + team);
                            ps2.println("Score: " + score);
                            record = txtScanner.nextLine();
                            ps2.println("Record: " + record);
                            ps2.println();
                            continue;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } catch (FileNotFoundException e2) {
            System.out.println("File not found.");
            e2.printStackTrace();
        }
    }

    /**
     *  Imports a local HTML file, containing all of the team names and real names, and
     *  filers/sorts the data using JSoup. The result is exported into a text document.
     */
    public void teamToRealName() {

        
        // input HTML file
        File names = new File("D:\\Fantasy Football\\Analytics\\2018\\Cousins\\Season\\Data" +
                "\\Names.html");
        Document doc1 = null;
        try {
            doc1 = (Document) Jsoup.parse(names, "UTF-8", " ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // search for team and real names
        Element nameSearcher = doc1.getElementById("teams");
        System.out.println("nameSearcher: " + nameSearcher);

        Element link = doc1.getElementById("team-3-name");
        System.out.println("link: " + link);
        for (int i = 1; i < 11; i++) {
            Element link2 = doc1.getElementById("team-" + i + "-name");
            System.out.println("link[" + i + "]: " + link2);
        }

    }

    public static void main(String[] args) {

        FF_Data_Automater test1 = new FF_Data_Automater();
//        test1.inputOutputData();
        test1.teamToRealName();


    }
}
