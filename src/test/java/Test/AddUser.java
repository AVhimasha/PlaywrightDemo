package Test;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Admin;
import pages.LoginPage;

public class AddUser extends BaseTest {

    LoginPage loginPage;
    Admin admin;

    @BeforeMethod
    public void loginSetup() { // Renamed method
        loginPage = new LoginPage(page);
        admin = new Admin(page);

        // *** CRITICAL FIX: Navigate to the login page before attempting to log in ***
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Login before each test
        loginPage.login("Admin", "admin123");
    }

    @Test
    public void addUser() {
        page.setDefaultTimeout(60000);

        // Use Admin page methods
        admin.navigateToAdmin();
        admin.clickAdd();
        admin.selectUserRole("Admin");
        admin.fillEmployeeName("James Butler");
        admin.selectStatus("Enabled");
        admin.fillUsername("James123");
        admin.fillPassword("James@123");
        admin.save();
        admin.verifySuccess();
    }
}