import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.AuthPage;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LoginFromPasswordRecoverFormTest extends BaseUrlTest{

    @Test
    @DisplayName("Проверка входа через кнопку в форме восстановления пароля")
    @Description("Проверка, что авторизация через кнопку в форме восстановления пароля успешная")
    public void isLoginFromPasswordRecoverFormCorrectTest(){
        driver.get("https://stellarburgers.nomoreparties.site/");

        AuthPage authPage = new AuthPage(driver);
        authPage.clickLoginToAccountButton();
        authPage.clickRecoverPasswordLinkForm();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(authPage.getLoginLinkOnRegForm()));
        authPage.clickLoginLinkOnRecoverPasswordForm();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(authPage.getPasswordField()));
        authPage.setLoginPassword();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(authPage.getLoginButton()));
        authPage.clickLoginButton();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(authPage.getOrderButton()));
        assertTrue("Авторизация не прошла", authPage.checkAuthorizationPassed());
    }

}
