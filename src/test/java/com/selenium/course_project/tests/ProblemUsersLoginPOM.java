package com.selenium.course_project.tests;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.selenium.course_project.tests.base.TestBaseUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ProblemUsersLoginPOM extends TestBaseUtil {
    @DataProvider(name = "problemUsersReadFromCsvFile")
    public Object [][] readWrongUsersFromCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/problemUsersList.csv"))) {
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObject = new Object[csvData.size()][2];
            for (int i = 0; i < csvData.size(); i++) {
                csvDataObject[i] = csvData.get(i);
            }
            return csvDataObject;
        }
    }

    @Test(dataProvider = "problemUsersReadFromCsvFile")
    public void problemUsersLogin(String userName, String password){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login(userName, password);
    }
}
