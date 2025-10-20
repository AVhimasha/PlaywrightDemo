package pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private final Page page;

    // Constructor
    public LoginPage(Page page){
        this.page = page;
    }

    // Methods to interact
    public void addUsername(String username){
        String usernameTextbox = "input[name='username']";
        page.fill(usernameTextbox, username);
    }

    public void addPassword(String password){
        String passwordTextbox = "input[name='password']";
        page.fill(passwordTextbox, password);
    }

    public void clickLogin(){
        String loginButton = "button[type='submit']";
        page.click(loginButton);
    }

    // Login helper (instance method)
    public void login(String username, String password){
        addUsername(username);
        addPassword(password);
        clickLogin();
    }
}