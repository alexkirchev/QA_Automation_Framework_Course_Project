package com.selenium.course_project.tests;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.selenium.course_project.tests.base.TestBaseUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class UnsuccessfulLoginPOM extends TestBaseUtil {

    @DataProvider(name = "wrongUsersReadFromCsvFile")
    public Object [][] readWrongUsersFromCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/wrongUsersList.csv"))) {
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObject = new Object[csvData.size()][2];
            for (int i = 0; i < csvData.size(); i++) {
                csvDataObject[i] = csvData.get(i);
            }
            return csvDataObject;
        }
    }

    @Test(dataProvider = "wrongUsersReadFromCsvFile")
    public void unsuccessfulLoginWithWrongUsers(String userName, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName, password);
    }
}
