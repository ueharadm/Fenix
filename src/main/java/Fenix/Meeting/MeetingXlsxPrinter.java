package Fenix.Meeting;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;

public class MeetingXlsxPrinter {

    private static final String meetingNumber = "Nº da reunião ";
    private static final String worshipfulMaster = "Venerável Mestre";
    private static final String meetingType = "Tipo";
    private static final String date = "Data";
    public static void printMeeting(Integer meetingId){

    }
    public static void printMeetings(List<Meeting> meetings, String fileName) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Meetings");

        // Create the header row
        XSSFRow headerRow = sheet.createRow(0);
        XSSFCell headerCell = headerRow.createCell(0);
        headerCell.setCellValue(meetingNumber);
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue(worshipfulMaster);
        headerCell = headerRow.createCell(2);
        headerCell.setCellValue(meetingType);
        headerCell = headerRow.createCell(3);
        headerCell.setCellValue(date);

        // Fill the rows with data
        int rowNum = 1;
        for (Meeting meeting : meetings) {
            XSSFRow dataRow = sheet.createRow(rowNum++);
            XSSFCell dataCell = dataRow.createCell(0);
            dataCell.setCellValue(meeting.getNumber());
            dataCell = dataRow.createCell(1);
            dataCell.setCellValue(meeting.getWorshipfulMasterId());
            dataCell = dataRow.createCell(2);
            dataCell.setCellValue(meeting.getType().toString());
            dataCell = dataRow.createCell(3);
            dataCell.setCellValue(meeting.getDate().toString());
        }

        // Save the workbook to a file
        FileOutputStream fileOut = new FileOutputStream(fileName);
        workbook.write(fileOut);
        fileOut.close();
    }
}

