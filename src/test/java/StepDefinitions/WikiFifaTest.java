package StepDefinitions;

import Pages.DialogContent;
import Utilities.ExcelUtilities;
import Utilities.ParameterDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WikiFifaTest {
    DialogContent dialogContent = new DialogContent();

    @Given("Navigate to the page")
    public void navigateToThePage() {
        ParameterDriver.getDriver().get("https://en.m.wikipedia.org/wiki/FIFA_World_Cup#Attendance");
    }

    @Then("Write all the Hosts in the Attendance table in excel file")
    public void writeAllTheHostsInTheAttendanceTableInExcelFile() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");

        for (int i = 0; i < dialogContent.listOfHostCountries.size(); i++) {
            Row row = sheet.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(dialogContent.listOfHostCountries.get(i).getText());
        }

        String path = "excelFiles/excelFile.xlsx";

        try {
            File directory = new File("excelFiles");
            if (!directory.exists()) {
                directory.mkdirs(); // Create directories if they don't exist
            }

            FileOutputStream fileOutputStream = new FileOutputStream(path);
            workbook.write(fileOutputStream);
            workbook.close();
            fileOutputStream.close();
            System.out.println("Excel file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}