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
                try {
                    for (int i = 1; i < 12; i++) {
//                    System.out.println("i: " + i);
//                    System.out.println("i % 2: " + (i % 2));

                        // odd teams
                        if (i % 2 != 0) {
//                        System.out.println("Method odd");
                            score = txtScanner.nextDouble();
                            System.out.println("Score: " + score);
                            // skip projected score
                            skip = txtScanner.nextDouble();
                            team = txtScanner.nextLine();
                            team = txtScanner.nextLine();
                            System.out.println("Team: " + team);
                            record = txtScanner.nextLine();
                            System.out.println("Record: " + record);
                            continue;
                        }

                        // even teams
                        if (i % 2 == 0) {
//                        System.out.println("Method even");
                            // skip logo
                            txtScanner.nextLine();
                            score = txtScanner.nextDouble();
                            System.out.println("Score: " + score);
                            // skip projected score
                            skip = txtScanner.nextDouble();
                            // skip logo
                            txtScanner.nextLine();
                            txtScanner.nextLine();
                            team = txtScanner.nextLine();
                            System.out.println("Team: " + team);
                            record = txtScanner.nextLine();
                            System.out.println("Record: " + record);
                            continue;
                        }
                    }
//
//                    // even teams
//                    if ((i % 2 == 0)) {
//                        // skip logo
//                        txtScanner.nextLine();
//                        score = txtScanner.nextDouble();
//                        System.out.println("Score: " + score);
//                        // skip projected score
//                        skip = txtScanner.nextDouble();
//                        team = txtScanner.nextLine();
//                        System.out.println("Team: " + team);
//                        record = txtScanner.nextLine();
//                        System.out.println("Record: " + record);
//                        continue;
//                    }
//
//
//
//                    score = txtScanner.nextDouble();
//                    if (txtScanner.hasNext("logo")) {
//                        txtScanner.nextLine();
//                    }
//                    System.out.println("Score: " + score);
//                        // skip projected score
//                    skip = txtScanner.nextDouble();
//                    txtScanner.nextLine();
////                    txtScanner.skip("logo");
////                    txtScanner.nextLine();
//                    team = txtScanner.nextLine();
//                    System.out.println("Team: " + team);
////                        //testing error
////                    System.out.println("nextInt: " + txtScanner.hasNextInt());
////                    System.out.println("next: " + txtScanner.hasNext());
////                    System.out.println("nextLine: " + txtScanner.hasNextLine());
////                    System.out.println("\\n: " + txtScanner.hasNext("\n"));
////                    System.out.println("printNext: " + txtScanner.next());
////                    System.out.println("printNextLine: " + txtScanner.nextLine());
//                    record = txtScanner.nextLine();
//                    System.out.println("Record: " + record);
//                    txtScanner.nextLine();
////                    txtScanner.skip("logo");
////                    wins = txtScanner.nextInt();
////                    System.out.println("Wins: " + wins);
////                    txtScanner.skip("-");
////                    losses = txtScanner.nextInt();
////                    System.out.println("Losses: " + losses);
////                    txtScanner.skip("-");
////                    ties = txtScanner.nextInt();
////                    System.out.println("Ties: " + ties);
                } catch (Exception e1) {
//                    e1.printStackTrace();
                }



            } catch (FileNotFoundException e2) {
                System.out.println("File not found.");
                e2.printStackTrace();
            }

        }
}