package Fenix.Meeting;

import Fenix.Member.Member;
import lombok.AllArgsConstructor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
@RestController
public class MeetingXlsxPrinter {

    private static final String meetingNumber = "Nº da reunião ";
    private static final String worshipfulMaster = "Venerável Mestre";
    private static final String meetingType = "Tipo";
    private static final String date = "Data";
    private static final String attendeeCount = "Qtd. de presentes";
    public static void printMeeting(Meeting meeting, String fileName) throws Exception{


        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Reunião "+meeting.getNumber());

        // Create the header row
        XSSFRow headerRow1 = sheet.createRow(0);
        XSSFCell headerCell = headerRow1.createCell(0);
        headerCell.setCellValue(meetingNumber);
        headerCell = headerRow1.createCell(1);
        headerCell.setCellValue(meeting.getNumber());
        headerCell = headerRow1.createCell(2);
        headerCell.setCellValue(worshipfulMaster);
        headerCell = headerRow1.createCell(3);
        headerCell.setCellValue(meeting.getWorshipfulMaster().getName());

        XSSFRow headerRow2 = sheet.createRow(1);
        headerCell = headerRow2.createCell(0);
        headerCell.setCellValue(meetingType);
        headerCell = headerRow2.createCell(1);
        headerCell.setCellValue(meeting.getType().toString());
        headerCell = headerRow2.createCell(2);
        headerCell.setCellValue(date);
        headerCell = headerRow2.createCell(3);
        headerCell.setCellValue(meeting.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE));

        XSSFRow headerRow3 = sheet.createRow(3);
        headerCell = headerRow3.createCell(0);
        headerCell.setCellValue("Nome");
        headerCell = headerRow3.createCell(1);
        headerCell.setCellValue("Matrícula");
        headerCell = headerRow3.createCell(2);
        headerCell.setCellValue("Grau");
        headerCell = headerRow3.createCell(3);
        headerCell.setCellValue("Loja");
        headerCell = headerRow3.createCell(4);
        headerCell.setCellValue("Dt. Nascimento");
        headerCell = headerRow3.createCell(5);
        headerCell.setCellValue("Dt. Iniciação");

        // Fill the rows with data
        int rowNum = 4;
        for (Member member : meeting.getAttendees()) {
            newMemberRow(sheet,rowNum++, member);
        }

        // Save the workbook to a file
        FileOutputStream fileOut = new FileOutputStream(fileName+".xlsx");
        workbook.write(fileOut);
        fileOut.close();
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
        headerCell = headerRow.createCell(4);
        headerCell.setCellValue(attendeeCount);

        // Fill the rows with data
        int rowNum = 1;
        for (Meeting meeting : meetings) {
            newMeetingRow(sheet, rowNum++, meeting);
        }

        // Save the workbook to a file
        FileOutputStream fileOut = new FileOutputStream(fileName);
        workbook.write(fileOut);
        fileOut.close();
    }

    public static void newMeetingRow(XSSFSheet sheet, int rowNum, Meeting meeting){
        XSSFRow dataRow = sheet.createRow(rowNum);
        XSSFCell dataCell = dataRow.createCell(0);
        dataCell.setCellValue(meeting.getNumber());
        dataCell = dataRow.createCell(1);
        dataCell.setCellValue(meeting.getWorshipfulMaster().getName());
        dataCell = dataRow.createCell(2);
        dataCell.setCellValue(meeting.getType().toString());
        dataCell = dataRow.createCell(3);
        dataCell.setCellValue(meeting.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
        dataCell = dataRow.createCell(4);
        dataCell.setCellValue(meeting.getAttendees().stream().count());
    }

    public static void newMemberRow(XSSFSheet sheet, int rowNum, Member member){
        XSSFRow dataRow = sheet.createRow(rowNum++);
        XSSFCell dataCell = dataRow.createCell(0);
        dataCell.setCellValue(member.getName());
        dataCell = dataRow.createCell(1);
        dataCell.setCellValue((member.getRegistration() != null) ? member.getRegistration() : 0);
        dataCell = dataRow.createCell(2);
        dataCell.setCellValue(member.getDegree().toString());
        dataCell = dataRow.createCell(3);
        dataCell.setCellValue(member.getLodge().getName());
        dataCell = dataRow.createCell(4);
        dataCell.setCellValue((member.getBirthDate() != null) ? member.getBirthDate().format(DateTimeFormatter.ISO_LOCAL_DATE) : LocalDate.of(1900,1,1).format(DateTimeFormatter.ISO_LOCAL_DATE));
        dataCell = dataRow.createCell(5);
        dataCell.setCellValue((member.getBirthDate() != null) ? member.getInitiationDate().format(DateTimeFormatter.ISO_LOCAL_DATE) : LocalDate.of(1900,1,1).format(DateTimeFormatter.ISO_LOCAL_DATE));
    }
}

