import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class FF_Data_Automater {

    public static void main(String[] args) {

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
            }
        } catch (FileNotFoundException e2) {
            System.out.println("File not found.");
            e2.printStackTrace();
        }


    }
}
