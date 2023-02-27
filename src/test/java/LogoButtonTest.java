import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.AuthPage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LogoButtonTest extends BaseUrlTest{

    @Before
    public void startUp() {
        super.before();
    }

    @Test
    @DisplayName("Проверка перехода по клику на логотип Stellar Burgers")
    @Description("Проверка, что при переходе по клику на логотип Stellar Burgers открывается страница создания бургера")
    public void isLogoButtonCorrectTest(){
        driver.get("https://stellarburgers.nomoreparties.site/");

        AuthPage authPage = new AuthPage(driver);
        authPage.clickLkButton();
        authPage.setLoginPassword();
        authPage.clickLoginButton();
        authPage.clickLogoButton();
        assertTrue("Некорректный переход по клику на логотип Stellar Burgers", authPage.checkAddBurgerHeaderIsPresent());
    }

}
