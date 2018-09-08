import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FF_Data_Automater {

        public static void main(String[] args) {

            // importing txt file
            File txtFile = new File("D:\\Fantasy Football\\Analytics\\2018\\Cousins\\Season\\Data" +
                    "\\Week.txt");
            try {
                Scanner txtScanner = new Scanner(txtFile);

                // getting input from txt file
                int week = txtScanner.nextInt();
                System.out.println("Week: " + week);
                    // scores and records for each team
                double score, skip;
                int wins, losses, ties;
                String team, record;
                for (int i = 0; i < 11; i ++) {
                    score = txtScanner.nextDouble();
                    System.out.println("Score: " + score);
                        // skip projected score
                    skip = txtScanner.nextDouble();
                    team = txtScanner.next();
                    System.out.println("Team: " + team);
//                        //testing error
//                    System.out.println("nextInt: " + txtScanner.hasNextInt());
//                    System.out.println("next: " + txtScanner.hasNext());
//                    System.out.println("nextLine: " + txtScanner.hasNextLine());
//                    System.out.println("\\n: " + txtScanner.hasNext("\n"));
//                    System.out.println("printNext: " + txtScanner.next());
//                    System.out.println("printNextLine: " + txtScanner.nextLine());
                    record = txtScanner.next();
                    System.out.println("Record: " + record);
//                    wins = txtScanner.nextInt();
//                    System.out.println("Wins: " + wins);
//                    txtScanner.skip("-");
//                    losses = txtScanner.nextInt();
//                    System.out.println("Losses: " + losses);
//                    txtScanner.skip("-");
//                    ties = txtScanner.nextInt();
//                    System.out.println("Ties: " + ties);



                }

            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                e.printStackTrace();
            }





        }
}
