
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.RegistrationPage;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.Random;
import java.util.stream.Collectors;

public class RegistrationTest extends BaseUrlTest{

    private final static String EMAIL_FIRST_PART = "elenagromova";
    private final static String EMAIL_LAST_PART = "@yandex.com";

    @Test
    @DisplayName("Проверка успешности регистрации пользователя")
    @Description("Проверка возможности зарегистрироваться с разными данными")
    public void isRegistratedTrueTest(){
        driver.get("https://stellarburgers.nomoreparties.site/register");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(registrationPage.getEmailField()));
        registrationPage.setRegistrationData("Andre", EMAIL_FIRST_PART + Math.round(Math.random() * ( 7000000 - 1 )) + EMAIL_LAST_PART, new Random().ints(10, 33, 122).mapToObj(i -> String.valueOf((char)i)).collect(Collectors.joining()));
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(registrationPage.getRegistrationButton()));
        registrationPage.clickRegistrationButton();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(registrationPage.getLoginButton()));
        assertEquals("Проверка регистрации пользователя некорректна", true, registrationPage.checkRegistrationPassed());
    }
}
