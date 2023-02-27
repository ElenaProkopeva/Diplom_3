import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.ConstructorPage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BunsSectionTest extends BaseUrlTest{

    @Before
    public void startUp() {
        super.before();
    }

    @Test
    @DisplayName("Проверка перехода к разделу Булки")
    @Description("Проверка, что при переходе в раздел Булки происходит фокус на данном разделе меню")
    public void isBunsSectionCorrectTest(){
        driver.get("https://stellarburgers.nomoreparties.site/");

        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickSousesSection();
        constructorPage.clickBunsSection();
        assertTrue("Открыт некорректный раздел меню", constructorPage.checkBunsSectionIsPresent());
    }

}
