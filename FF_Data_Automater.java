import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class FF_Data_Automater {

    public static void main(String[] args) {

        // exporting to txt file


        // importing data from txt file
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
            // scores and records for each team
            double score, skip;
            int wins, losses, ties;
            String team, record;
            try {
                for (int i = 1; i < 12; i++) {
//                    ps2.println("i: " + i);
//                    ps2.println("i % 2: " + (i % 2));

                    // odd teams
                    if (i % 2 != 0) {
//                        ps2.println("Method odd");
                        score = txtScanner.nextDouble();
                        ps2.println("Score: " + score);
                        // skip projected score
                        skip = txtScanner.nextDouble();
                        team = txtScanner.nextLine();
                        team = txtScanner.nextLine();
                        ps2.println("Team: " + team);
                        record = txtScanner.nextLine();
                        ps2.println("Record: " + record);
                        continue;
                    }

                    // even teams
                    if (i % 2 == 0) {
//                        ps2.println("Method even");
                        // skip logo
                        txtScanner.nextLine();
                        score = txtScanner.nextDouble();
                        ps2.println("Score: " + score);
                        // skip projected score
                        skip = txtScanner.nextDouble();
                        // skip logo
                        txtScanner.nextLine();
                        txtScanner.nextLine();
                        team = txtScanner.nextLine();
                        ps2.println("Team: " + team);
                        record = txtScanner.nextLine();
                        ps2.println("Record: " + record);
                        continue;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
//
//                    // even teams
//                    if ((i % 2 == 0)) {
//                        // skip logo
//                        txtScanner.nextLine();
//                        score = txtScanner.nextDouble();
//                        ps2.println("Score: " + score);
//                        // skip projected score
//                        skip = txtScanner.nextDouble();
//                        team = txtScanner.nextLine();
//                        ps2.println("Team: " + team);
//                        record = txtScanner.nextLine();
//                        ps2.println("Record: " + record);
//                        continue;
//                    }
//
//
//
//                    score = txtScanner.nextDouble();
//                    if (txtScanner.hasNext("logo")) {
//                        txtScanner.nextLine();
//                    }
//                    ps2.println("Score: " + score);
//                        // skip projected score
//                    skip = txtScanner.nextDouble();
//                    txtScanner.nextLine();
////                    txtScanner.skip("logo");
////                    txtScanner.nextLine();
//                    team = txtScanner.nextLine();
//                    ps2.println("Team: " + team);
////                        //testing error
////                    ps2.println("nextInt: " + txtScanner.hasNextInt());
////                    ps2.println("next: " + txtScanner.hasNext());
////                    ps2.println("nextLine: " + txtScanner.hasNextLine());
////                    ps2.println("\\n: " + txtScanner.hasNext("\n"));
////                    ps2.println("printNext: " + txtScanner.next());
////                    ps2.println("printNextLine: " + txtScanner.nextLine());
//                    record = txtScanner.nextLine();
//                    ps2.println("Record: " + record);
//                    txtScanner.nextLine();
////                    txtScanner.skip("logo");
////                    wins = txtScanner.nextInt();
////                    ps2.println("Wins: " + wins);
////                    txtScanner.skip("-");
////                    losses = txtScanner.nextInt();
////                    ps2.println("Losses: " + losses);
////                    txtScanner.skip("-");
////                    ties = txtScanner.nextInt();
////                    ps2.println("Ties: " + ties);
            } catch (Exception e1) {
//                    e1.printStackTrace();
            }



        } catch (FileNotFoundException e2) {
            System.out.println("File not found.");
            e2.printStackTrace();
        }

    }
}
