import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.ConstructorPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SousesSectionTest extends BaseUrlTest{

    @Test
    @DisplayName("Проверка перехода к разделу Соусы")
    @Description("Проверка, что при переходе в раздел Соусы происходит фокус на данном разделе меню")
    public void isSousesSectionTest(){
        driver.get("https://stellarburgers.nomoreparties.site/");

        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickSousesSection();
        assertTrue("Открыт некорректный раздел меню", constructorPage.checkSousesSectionIsPresent());
    }

}
