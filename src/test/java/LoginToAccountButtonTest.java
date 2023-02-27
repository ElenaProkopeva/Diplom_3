import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.AuthPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LoginToAccountButtonTest extends BaseUrlTest{

    @Before
    public void startUp() {
        super.before();
    }

    @Test
    @DisplayName("Проверка входа по кнопке «Войти в аккаунт» на главной")
    @Description("Проверка, что авторизация через кнопку «Войти в аккаунт» на главной успешная")
    public void isLoginToAccountButtonCorrectTest(){
        driver.get("https://stellarburgers.nomoreparties.site/");

        AuthPage authPage = new AuthPage(driver);
        authPage.clickLoginToAccountButton();
        authPage.setLoginPassword();
        authPage.clickLoginButton();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(authPage.getOrderButton()));
        assertTrue("Авторизация не прошла", authPage.checkAuthorizationPassed());
    }

}
