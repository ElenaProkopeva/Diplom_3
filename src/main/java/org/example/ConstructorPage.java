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
 //   private By bunsHeader = By.xpath(".//body/div/div/main/section[1]/div[1]/div[1][@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");
    private By bunsHeader = By.xpath("/html/body/div/div/main/section[1]/div[1]/div[1]/span");
    //заголовок ассортимента вкладки Булки
    private By bunsMenu = By.xpath(".//h2[@class='text text_type_main-medium mb-6 mt-10' and text()= 'Булки']");
    //вкладка Соусы
    private By sousesHeader = By.xpath("/html/body/div/div/main/section[1]/div[1]/div[2]/span");
    //заголовок ассортимента вкладки Соусы
    private By sousesMenu = By.xpath(".//h2[@class='text text_type_main-medium mb-6 mt-10' and text()= 'Соусы']");
    //вкладка Начинки
    private By ingredientsHeader = By.xpath("/html/body/div/div/main/section[1]/div[1]/div[3]/span");
    //заголовок ассортимента вкладки Начинки
    private By ingredientsMenu = By.xpath(".//h2[@class='text text_type_main-medium mb-6 mt-10' and text()= 'Начинки']");

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickConstructorButton(){
        driver.findElement(constructorButton).click();
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
