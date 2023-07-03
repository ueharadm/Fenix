package Fenix.Attendance;

import Fenix.Meeting.Meeting;
import Fenix.Member.Member;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AttendanceXlsxPrinter {


    public static void generateReport(LocalDate initDate, LocalDate finalDate, List<MemberAttendanceRecord> memberRates) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Taxa de presença");
        int numRow = 0;

        // Create the header row
        XSSFRow headerRow1 = sheet.createRow(numRow);
        XSSFCell headerCell = headerRow1.createCell(0);
        headerCell.setCellValue("Data inicial:");
        headerCell = headerRow1.createCell(1);
        headerCell.setCellValue(initDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
        headerCell = headerRow1.createCell(2);
        headerCell.setCellValue("Data final: ");
        headerCell = headerRow1.createCell(3);
        headerCell.setCellValue(finalDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
        numRow++;

        XSSFRow headerRow3 = sheet.createRow(numRow);
        headerCell = headerRow3.createCell(0);
        headerCell.setCellValue("Nome");
        headerCell = headerRow3.createCell(1);
        headerCell.setCellValue("Matrícula");
        headerCell = headerRow3.createCell(2);
        headerCell.setCellValue("Grau");
        headerCell = headerRow3.createCell(3);
        headerCell.setCellValue("Loja");
        headerCell = headerRow3.createCell(4);
        headerCell.setCellValue("Taxa de presença");

        for (MemberAttendanceRecord record: memberRates) {
            numRow++;
            Member member = record.member();
            XSSFRow dataRow = sheet.createRow(numRow);
            XSSFCell dataCell = dataRow.createCell(0);
            dataCell.setCellValue(member.getName());
            dataCell = dataRow.createCell(1);
            dataCell.setCellValue(member.getRegistration() != null ? member.getRegistration() : 0);
            dataCell = dataRow.createCell(2);
            dataCell.setCellValue(member.getDegree().toString());
            dataCell = dataRow.createCell(3);
            dataCell.setCellValue(member.getLodge().getName());
            dataCell = dataRow.createCell(4);
            dataCell.setCellValue(record.rate());
        }

        // Save the workbook to a file
        FileOutputStream fileOut = new FileOutputStream("Presenca_"+initDate.format(DateTimeFormatter.ISO_LOCAL_DATE)+"_"+finalDate.format(DateTimeFormatter.ISO_LOCAL_DATE)+".xlsx");
        workbook.write(fileOut);
        fileOut.close();

    }
}