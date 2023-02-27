import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.RegistrationPage;
import org.testng.asserts.SoftAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;
import java.util.stream.Collectors;


@RunWith(Parameterized.class)
public class PasswordRegistrationTest extends BaseUrlTest{

    private final static String EMAIL_FIRST_PART = "g";
    private final static String EMAIL_LAST_PART = "elenagromova@yandex.com";
    SoftAssert softAssert = new SoftAssert();


    String name;
    String email;
    String password;
    boolean isPasswordCorrect;

    public PasswordRegistrationTest(String name, String email, String password, boolean isPasswordCorrect) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isPasswordCorrect = isPasswordCorrect;
    }

    @Parameterized.Parameters
    public static Object[][] regData() {
        return new Object[][]{
                {"Andre", EMAIL_FIRST_PART + Math.round(Math.random() * ( 7000000 - 1 )) + EMAIL_LAST_PART, new Random().ints(5, 33, 122).mapToObj(i -> String.valueOf((char)i)).collect(Collectors.joining()), false},
                {"Andre", EMAIL_FIRST_PART + Math.round(Math.random() * ( 7000000 - 1 )) + EMAIL_LAST_PART, " ", false},
        };
    }

    @Test
    @DisplayName("Проверка пароля при регистрации пользователя")
    @Description("Проверка, что пароль соответствует требованиям: минимальная длина = 6 символов")
    public void isPasswordRegistrationCorrectTest(){
        driver.get("https://stellarburgers.nomoreparties.site/register");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(registrationPage.getEmailField()));
        registrationPage.setRegistrationData(name, email, password);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(registrationPage.getRegistrationButton()));
        registrationPage.clickRegistrationButton();

        softAssert.assertEquals(isPasswordCorrect, registrationPage.checkPasswordIsCorrect(password), "Проверка, что пароль соответствует требованиям, некорректна");
        softAssert.assertNotEquals(isPasswordCorrect, registrationPage.checkPasswordErrorIsDisplayed(), "Проверка, что пароль соответствует требованиям, некорректна");
        softAssert.assertNotEquals(isPasswordCorrect, registrationPage.checkPasswordErrorText().equals("Некорректный пароль"), "Проверка, что отображается текст сообщения об ошибочном пароле, некорректна");
        softAssert.assertAll();
    }
}
