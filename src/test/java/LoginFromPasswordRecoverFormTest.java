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

public class LoginFromPasswordRecoverFormTest extends BaseUrlTest{

    @Before
    public void startUp() {
        super.before();
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме восстановления пароля")
    @Description("Проверка, что авторизация через кнопку в форме восстановления пароля успешная")
    public void isLoginFromPasswordRecoverFormCorrectTest(){
        driver.get("https://stellarburgers.nomoreparties.site/");

        AuthPage authPage = new AuthPage(driver);
        authPage.clickLoginToAccountButton();
        authPage.clickRecoverPasswordLinkForm();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(authPage.getLoginLinkOnRegForm()));
        authPage.clickLoginLinkOnRecoverPasswordForm();
        driver.findElement(By.xpath("/html/body/div/div/main/div/div/p/a")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(authPage.getEmailField()));
        authPage.setLoginPassword();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(authPage.getLoginButton()));
        authPage.clickLoginButton();
        //driver.findElement(authPage.getLoginButton()).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(authPage.getOrderButton()));
        assertTrue("Авторизация не прошла", authPage.checkAuthorizationPassed());
    }

}
