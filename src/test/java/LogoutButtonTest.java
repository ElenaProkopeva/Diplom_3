import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.AuthPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LogoutButtonTest extends BaseUrlTest{

    @Before
    public void startUp() {
        super.before();
    }

    @Test
    @DisplayName("Проверка перехода по кнопке «Выйти» в личном кабинете")
    @Description("Проверка, что происходит выход по кнопке «Выйти» в личном кабинете.")
    public void isLogoutButtonCorrectTest(){
        driver.get("https://stellarburgers.nomoreparties.site/");

        AuthPage authPage = new AuthPage(driver);
        authPage.clickLkButton();
        authPage.setLoginPassword();
        authPage.clickLoginButton();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/header/nav/a")));
        driver.findElement(authPage.getLkButtonAfterAuth()).click();
        authPage.clickLkButtonAfterAuth();
        //authPage.clickLkButton();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(authPage.getLogoutButton()));
        authPage.clickLogoutButton();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(authPage.getLoginHeader()));
        assertTrue("Некорректный выход из ЛК", authPage.checkLoginHeaderIsPresent());
    }

}
