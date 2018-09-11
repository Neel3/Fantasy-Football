import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
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
     *  Imports team names and scores from an HTML file and prints to output.
     */
    public void outputScores() {

        // input HTML file
        File names = new File("D:\\Fantasy Football\\Analytics\\2018\\Cousins\\Season" +
                "\\Scores.html");
        Document doc1 = null;
        try {
             doc1 = (Document) Jsoup.parse(names, "UTF-8", " ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Store team ID into arrays
        Elements x4 = doc1.getElementsByClass("F-link");
//        System.out.println("x4: " + x4);
        String x5 = x4.toString();
        System.out.println("x5: " + x5);
        String x6 = x5.substring(35,36);
        System.out.println("x6: " + x6);
        Scanner x7 = new Scanner(x5);
        int teamID[] = new int[10];
        for (int i = 0; i < 10; i++) {
            String x8 = x7.nextLine();
//            Scanner x9 = new Scanner(x8.substring(35,36));
            String x10;
            if (x8.contains("10")) {
                x10 = x8.substring(35,37);
            }
            else {
                x10 = x8.substring(35, 36);
            }
            int x11 = Integer.parseInt(x10);
            teamID[i] = x11;
            System.out.println("teamID[" + i + "]: " + teamID[i]);
//            if (x8.substring(36,37).)
        }

        // Change team ID into real name
        String realNames[] = new String[10];
        for (int i = 0; i < 10; i++) {
            switch (teamID[i]) {
                case 1: {
                    realNames[i] = "Sagar";
                    break;
                }
                case 2: {
                    realNames[i] = "Cheerag";
                    break;
                }
                case 3: {
                    realNames[i] = "Rachna";
                    break;
                }
                case 4: {
                    realNames[i] = "Kunaal";
                    break;
                }
                case 5: {
                    realNames[i] = "Pooja";
                    break;
                }
                case 6: {
                    realNames[i] = "Nimesh";
                    break;
                }
                case 7: {
                    realNames[i] = "Kamal";
                    break;
                }
                case 8: {
                    realNames[i] = "Neel";
                    break;
                }
                case 9: {
                    realNames[i] = "Deep";
                    break;
                }
                case 10: {
                    realNames[i] = "Dhruv";
                    break;
                }
            }
        }

        //Scores
        Elements x1 = doc1.select("div.Fz-lg");
        String x2 = x1.select("div.Fz-lg").text();
//        System.out.println("x1: " + x1);
        System.out.println("x2: " + x2);
        Scanner x3 = new Scanner(x2);

        // skip words
        for (int i = 0; i < 4; i++) {
            x3.next();
        }
        // store scores into array
        double scoreArray[] = new double[10];
        for (int i = 0; i < 10; i++) {
            scoreArray[i] = x3.nextDouble();
//            System.out.println("[" + i + "]: " + x3.nextDouble());
//            System.out.println("teamID[" + teamID[i] + "]: " + scoreArray[i]);
            System.out.println(realNames[i] + ": " + scoreArray[i]);
        }

        // store opponents into array
        String opponentsArray[] = new String[10];
        for (int i = 0; i < 10; i ++) {
            if (i % 2 == 0) {
                opponentsArray[i] = realNames[i+1];
            }
            if (i % 2 != 0) {
                opponentsArray[i] = realNames[i-1];
            }
            System.out.println("opponentsArray[" + i + "]: " + opponentsArray[i]);
        }


//        // format for excel
//        System.out.println("Name\tOpponent\tPoints For\tPoints Against");
//        for (int i = 0; i < 10; i ++) {
//            if (i % 2 == 0) {
//                System.out.println(realNames[i] + "\t" + realNames[i+1] + "\t\t" + scoreArray[i] +
//                        "\t\t" + scoreArray[i+1]);
//            }
//            if (i % 2 != 0) {
//                System.out.println(realNames[i] + "\t" + realNames[i-1] + "\t\t" + scoreArray[i] +
//                        "\t\t" + scoreArray[i-1]);
//            }
//        }

//        HSSFWorkbook test2 = new HSSFWorkbook();
        // import excel file
        HSSFWorkbook test2 = null;
        try {
            test2 = new HSSFWorkbook(new FileInputStream("D:\\Fantasy " +
                    "Football\\Analytics\\2018\\Cousins\\Weekly_data_2018.xls"));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        HSSFSheet sheet1 = test2.createSheet("java_sheet");

        /*
        Export data to new tab for the week
         */
        // create new sheet per week
        int week = 2;
        HSSFSheet sheet1 = test2.createSheet("Week " + week);

        // create cells and rows
        HSSFRow rows[] = new HSSFRow[150];
        HSSFCell cells[] = new HSSFCell[4];
        for (int i = 1; i < 11; i++) {
            rows[i] = sheet1.createRow(i);
            for (int j = 0; j < 4; j++) {
                cells[j] = rows[i].createCell(j);
            }

            // sort data into excel rows and columns
                // names
                cells[0].setCellValue(realNames[(i-1)]);
                // opponents
                if ((i-1) % 2 != 0) {
                    cells[1].setCellValue(realNames[(i-1) - 1]);
                }
                if ((i-1) % 2 == 0) {
                    cells[1].setCellValue(realNames[(i-1) + 1]);
                }
                // points for
                cells[2].setCellValue(scoreArray[(i-1)]);
                // points against
                if ((i-1) % 2 != 0) {
                    cells[3].setCellValue(scoreArray[(i-1) - 1]);
                }
                if ((i-1) % 2 == 0) {
                    cells[3].setCellValue(scoreArray[(i-1) + 1]);
                }
        }

        // headers
        rows[0] = sheet1.createRow(0);
        for (int i = 0; i < 4; i++) {
            cells[i] = rows[0].createCell(i);
        }
        cells[0] = rows[0].createCell(0);
        cells[0].setCellValue("Name");
        cells[1] = rows[0].createCell(1);
        cells[1].setCellValue("Opponent");
        cells[2] = rows[0].createCell(2);
        cells[2].setCellValue("Points For");
        cells[3] = rows[0].createCell(3);
        cells[3].setCellValue("Points Against");


//        // export to excel
//        try {
//            test2.write(new FileOutputStream("D:\\Fantasy " +
//                    "Football\\Analytics\\2018\\Cousins\\Weekly_data_2018.xls"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            test2.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        /*
        Export data to totals sheet containing every week
         */
        // import totals sheet from excel file
        HSSFSheet sheetTotal = test2.getSheetAt(0);

        // create cells and rows
        int rowStart = ((week * 10) - 9);
        for (int i = rowStart; i < (rowStart + 10); i++) {
            rows[i] = sheetTotal.createRow(i);
            for (int j = 0; j < 4; j++) {
                cells[j] = rows[i].createCell(j);
            }
            // sort data into excel rows and columns
            int k = (i - ((week - 1) * 10));
                // names
                cells[0].setCellValue(realNames[(k - 1)]);
                // opponents
                if ((k - 1) % 2 != 0) {
                    cells[1].setCellValue(realNames[(k - 1) - 1]);
                }
                if ((k - 1) % 2 == 0) {
                    cells[1].setCellValue(realNames[(k - 1) + 1]);
                }
                // points for
                cells[2].setCellValue(scoreArray[(k - 1)]);
                // points against
                if ((k - 1) % 2 != 0) {
                    cells[3].setCellValue(scoreArray[(k - 1) - 1]);
                }
                if ((k - 1) % 2 == 0) {
                    cells[3].setCellValue(scoreArray[(k - 1) + 1]);
                }
        }






        // export data to excel sheet
        try {
            test2.write(new FileOutputStream("D:\\Fantasy " +
                    "Football\\Analytics\\2018\\Cousins\\Weekly_data_2018.xls"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            test2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }

    public static void main(String[] args) {

        FF_Data_Automater test1 = new FF_Data_Automater();
//        test1.inputOutputData();
        test1.outputScores();

        // get the week from input
//        Scanner weekInput = new Scanner(System.in);
//        System.out.print("What week is it? ");
//        int week = weekInput.nextInt();

        //excel rows
//        int rowStart = (week * 10) - 9;


    }
}
