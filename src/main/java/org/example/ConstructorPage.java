package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorPage {

    private WebDriver driver;
    //кнопка Конструктор
    private By constructorButton = By.xpath(".//header[@class='AppHeader_header__linkText__3q_va ml-2' and text()= 'Конструктор']");
    //заголовок Соберите бургер
    private By burgerHeader = By.xpath(".//h1[@class='text text_type_main-large mb-5 mt-10' and text()= 'Соберите бургер']");
    //вкладка Булки
    private By bunsHeader = By.xpath(".//div[1][@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']");
    //заголовок ассортимента вкладки Булки
    private By bunsMenu = By.xpath(".//div[1][@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");
    //вкладка Соусы
    private By sousesHeader = By.xpath(".//div[2][@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']");
    //заголовок ассортимента вкладки Соусы
    private By sousesMenu = By.xpath(".//div[2][@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");
    //вкладка Начинки
    private By ingredientsHeader = By.xpath(".//div[3][@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']");
    //заголовок ассортимента вкладки Начинки
    private By ingredientsMenu = By.xpath(".//div[3][@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBunsSection(){
        driver.findElement(bunsHeader).click();
    }

    public boolean checkBunsSectionIsPresent(){
        return driver.findElement(bunsMenu).isDisplayed();
    }

    public void clickSousesSection(){
        driver.findElement(sousesHeader).click();
    }

    public boolean checkSousesSectionIsPresent(){
        return driver.findElement(sousesMenu).isDisplayed();
    }

    public void clickIngredientsSection(){
        driver.findElement(ingredientsHeader).click();
    }

    public boolean checkIngredientsSectionIsPresent(){
        return driver.findElement(ingredientsMenu).isDisplayed();
    }
}
