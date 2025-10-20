package Test;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {

        page.setDefaultTimeout(60000);

        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);

        test.info("Navigate to login page");
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        test.info("Enter Valid Credentials");
        loginPage.login("Admin", "admin123"); // Corrected to call 'login'

        test.info("Navigate to home page");
        homePage.dashboard();

        test.info("All Test completed");

    }


}