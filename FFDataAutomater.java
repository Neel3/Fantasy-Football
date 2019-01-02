import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FF_Data_Automater_NEW {

    public static void main(String[] args) {

        /*
        Get data from HTML file
         */

        // input HTML file
        File dataHTML = new File("D:\\Fantasy Football\\Analytics\\2018\\Cousins\\Season" +
                "\\Scores.html");
        Document doc1 = null;
        try {
            doc1 = Jsoup.parse(dataHTML, "UTF-8", " ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // get team IDs from HTML file
        Elements docEle1 = doc1.getElementsByClass("F-link");
        String docEleToString1 = docEle1.toString();
        Scanner docScanner1 = new Scanner(docEleToString1);
        int teamID[] = new int[10];

        // store team IDs into array
        for (int i = 0; i < 10; i++) {
            String scannerNL1 = docScanner1.nextLine();
            String scannerTrim1;
            if (scannerNL1.contains("10")) {
                scannerTrim1 = scannerNL1.substring(35,37);
            }
            else {
                scannerTrim1 = scannerNL1.substring(35, 36);
            }
            int scannerTeamID = Integer.parseInt(scannerTrim1);
            teamID[i] = scannerTeamID;
        }

        // change team IDs into real names
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

        // get scores from HTML file
        Elements docEle2 = doc1.select("div.Fz-lg");
        String docEleToString2 = docEle2.select("div.Fz-lg").text();
        Scanner docScanner2 = new Scanner(docEleToString2);
        // skip words
        for (int i = 0; i < 4; i++) {
            docScanner2.next();
        }
        // store scores into array
        double scoreArray[] = new double[10];
        for (int i = 0; i < 10; i++) {
            scoreArray[i] = docScanner2.nextDouble();
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
        }

        /*
        Export data to new tab in excel workbook for the week
         */

        // open excel workbook
        XSSFWorkbook workbook2 = null;
        try {
            workbook2 = new XSSFWorkbook(new FileInputStream("D:\\Fantasy " +
                    "Football\\Analytics\\2018\\Cousins\\Weekly_data_2018_New.xlsx"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // create new sheet per week
        Scanner weekInput = new Scanner(System.in);
        System.out.print("Enter the week number: ");
        int week = weekInput.nextInt();
        XSSFSheet sheet1 = workbook2.createSheet("Week " + week);

        // create cells and rows
        XSSFRow rows[] = new XSSFRow[150];
        XSSFCell cells[] = new XSSFCell[5];
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

        // autosize columns
        for (int i = 0; i < 5; i++) {
            sheet1.autoSizeColumn(i);
        }

        /*
        Export data to totals sheet containing data from every week
         */

        // import totals sheet from excel file
        XSSFSheet sheetTotal = workbook2.getSheetAt(0);

        // create cells and rows
        int rowStart = ((week * 10) - 9);
        for (int i = rowStart; i < (rowStart + 10); i++) {
            rows[i] = sheetTotal.createRow(i);
            for (int j = 0; j < 5; j++) {
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
            // week
            cells[4].setCellValue(week);
        }

        // export data to excel sheet
        try {
            workbook2.write(new FileOutputStream("D:\\Fantasy " +
                    "Football\\Analytics\\2018\\Cousins\\Weekly_data_2018_New.xlsx"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            workbook2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
