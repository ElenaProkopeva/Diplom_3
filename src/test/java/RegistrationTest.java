
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.RegistrationPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.Random;
import java.util.stream.Collectors;

@RunWith(Parameterized.class)
public class RegistrationTest extends BaseUrlTest{

    private final static String EMAIL_FIRST_PART = "elenagromova";
    private final static String EMAIL_LAST_PART = "@yandex.com";

    String name;
    String email;
    String password;
    boolean isRegistrated;

    public RegistrationTest(String name, String email, String password, boolean isRegistrated) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isRegistrated = isRegistrated;
    }

    @Parameterized.Parameters
    public static Object[][] regData() {
        return new Object[][]{
                {"Andre", EMAIL_FIRST_PART + Math.round(Math.random() * ( 7000000 - 1 )) + EMAIL_LAST_PART, new Random().ints(10, 33, 122).mapToObj(i -> String.valueOf((char)i)).collect(Collectors.joining()), true},
                {"Andre", null, null, false},
        };
    }

    @Before
    public void startUp() {
        super.before();
    }

    @Test
    @DisplayName("Проверка успешности регистрации пользователя")
    @Description("Проверка возможности зарегистрироваться с разными данными")
    public void isRegistratedTrueTest(){
        driver.get("https://stellarburgers.nomoreparties.site/register");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(registrationPage.getEmailField()));
        registrationPage.setRegistrationData(name, email, password);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(registrationPage.getRegistrationButton()));
        registrationPage.clickRegistrationButton();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(registrationPage.getLoginHeader()));
        assertEquals("Проверка регистрации пользователя некорректна", isRegistrated, registrationPage.checkRegistrationPassed());
    }
}
