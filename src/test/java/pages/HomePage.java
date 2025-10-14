package pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;
    private final String dashboard = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[1]/a/div[2]";

    public HomePage(Page page){
        this.page = page;
    }

    public void dashboard(){
        //page.isVisible("client brand banner");
        page.locator(dashboard).isVisible();
    }
}
