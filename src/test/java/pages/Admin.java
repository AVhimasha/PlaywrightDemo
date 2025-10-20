package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Admin {

    private final Page page;

    public Admin(Page page) {
        this.page = page;
    }

    public void navigateToAdmin() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Admin")).click();
    }

    public void clickAdd() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Add")).click();
    }

    public void selectUserRole(String role) {
        page.locator("form i").first().click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Admin")).click();
    }

    public void selectStatus(String status) {
        page.locator("form i").nth(1).click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName(status)).click();
    }

    public void fillEmployeeName(String name) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Type for hints...")).fill(name);
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName(name)).click();
    }

    public void fillUsername(String username) {
        page.getByRole(AriaRole.TEXTBOX).nth(2).fill(username);
    }

    public void fillPassword(String password) {
        // IMPROVEMENT: Using generic nth locators for password fields is fragile.
        // Assuming a standard form where the 4th textbox is "Password" and 5th is "Confirm Password"
        // In a real application, use a name/placeholder for stability.

        // This keeps the original logic, but is noted as brittle:
        page.getByRole(AriaRole.TEXTBOX).nth(3).fill(password); // Password field
        page.getByRole(AriaRole.TEXTBOX).nth(4).fill(password); // Confirm Password field

        // Example of a more robust locator (if attributes were known):
        // page.getByPlaceholder("Password").fill(password);
        // page.getByPlaceholder("Confirm Password").fill(password);
    }

    public void save() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
    }

    public void verifySuccess() {
        assertThat(page.getByText("Success", new Page.GetByTextOptions().setExact(true))).isVisible();
    }
}