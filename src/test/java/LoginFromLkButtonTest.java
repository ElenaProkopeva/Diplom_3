import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.AuthPage;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LoginFromLkButtonTest extends BaseUrlTest{

    @Test
    @DisplayName("Проверка входа по кнопке «Личный кабинет» на главной")
    @Description("Проверка, что авторизация через кнопку «Личный кабинет» на главной успешная")
    public void isPasswordCorrectTest(){
        driver.get("https://stellarburgers.nomoreparties.site/");

        AuthPage authPage = new AuthPage(driver);
        authPage.clickLkButton();
        authPage.setLoginPassword();
        authPage.clickLoginButton();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(authPage.getOrderButton()));
        assertTrue("Авторизация не прошла", authPage.checkAuthorizationPassed());
    }

}
