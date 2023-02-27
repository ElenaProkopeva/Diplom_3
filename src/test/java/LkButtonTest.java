import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.AuthPage;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LkButtonTest extends BaseUrlTest{

    @Test
    @DisplayName("Проверка перехода по клику на «Личный кабинет»")
    @Description("Проверка, что при переходе по клику на «Личный кабинет» открывается страница профиля")
    public void isLkButtonClickCorrectTest(){
        driver.get("https://stellarburgers.nomoreparties.site/");

        AuthPage authPage = new AuthPage(driver);
        authPage.clickLkButton();
        authPage.setLoginPassword();
        authPage.clickLoginButton();
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(authPage.getLkButton()));
        authPage.clickLkButton();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(authPage.getProfileHeader()));
        assertTrue("Некорректныйй переход по кнопке Личный кабинет", authPage.checkProfileHeaderIsPresent());
    }

}
