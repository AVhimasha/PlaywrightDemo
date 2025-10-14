package Test;

import base.BaseTest;
import org.testng.annotations.Test;


public class FirstTest extends BaseTest {

    @Test
    public void VerifyTitle(){
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("This Page Title is : "+ page.title());
    }



}
