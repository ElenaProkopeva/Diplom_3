import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.AuthPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConstructorButtonTest extends BaseUrlTest{

    @Test
    @DisplayName("Проверка перехода по клику на «Конструктор»")
    @Description("Проверка, что при переходе по клику на «Конструктор» открывается страница создания бургера")
    public void isConstructorButtonClickCorrectTest(){
        driver.get("https://stellarburgers.nomoreparties.site/");

        AuthPage authPage = new AuthPage(driver);
        authPage.clickLkButton();
        authPage.setLoginPassword();
        authPage.clickLoginButton();
        authPage.clickConstructorButton();
        assertTrue("Некорректный переход по кнопке Конструктор", authPage.checkAddBurgerHeaderIsPresent());
    }

}
