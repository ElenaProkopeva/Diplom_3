package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthPage {

    private final static String LOGIN = "g777elenagromova@yandex.com";
    private final static String PASSWORD = "g777elenagromova@yandex.com";

    private WebDriver driver;
    //кнопка Войти в аккаунт
    private By loginToAccountButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text()= 'Войти в аккаунт']");
    //ссылка Зарегистрироваться
    private By registrationLink = By.xpath(".//p[1]/a[@class='Auth_link__1fOlj' and text()= 'Зарегистрироваться']");
    //ссылка Войти в блоке "Уже зарегистрированы? Войти"
    private By loginLinkOnRegForm = By.xpath(".//a[@class='Auth_link__1fOlj' and text()= 'Войти']");
    //ссылка Восстановить пароль
    private By recoverPasswordLink = By.xpath(".//p[2]/a[@class='Auth_link__1fOlj' and text()= 'Восстановить пароль']");
    //ссылка Войти в блоке "Вспомнили пароль? Войти"
    private By loginLinkOnRecoverPasswordForm = By.xpath(".//a[@class='Auth_link__1fOlj' and text()= 'Войти']");
    //поле Email
    private By emailField = By.xpath(".//fieldset[1]/div/div/input[@class='text input__textfield text_type_main-default' and @name='name']");

    //поле Пароль
    private By passwordField = By.xpath(".//fieldset[2]/div/div/input[@class='text input__textfield text_type_main-default' and @name= 'Пароль']");
    //кнопка Войти
    private By loginButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text()= 'Войти']");
    //элемент подтверждения успешной авторизации - кнопка Оформить заказ
    private By orderButton = By.xpath(".//section[2]/div/button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text()= 'Оформить заказ']");

    //кнопка Личный кабинет
    private By lkButton = By.xpath(".//a/p[@class='AppHeader_header__linkText__3q_va ml-2' and text()= 'Личный Кабинет']");

    //заголовок раздела Профиль
    private By profileHeader = By.xpath(".//ul/li[1]/a[@class='Account_link__2ETsJ text text_type_main-medium text_color_inactive Account_link_active__2opc9' and text()= 'Профиль']");
    //кнопка Выход
    private By logoutButton = By.xpath(".//ul/li[3]/button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive' and text()= 'Выход']");
    //кнопка Конструктор
    private By constructorButton = By.xpath(".//ul/li[1]/a/p[@class='AppHeader_header__linkText__3q_va ml-2' and text()= 'Конструктор']");
    //кнопка логотипа
    private By logoButton = By.className("AppHeader_header__logo__2D0X2");
    //Заголовок "Соберите бургер"
    private By addBurgerHeader = By.xpath(".//section[1]/h1[@class='text text_type_main-large mb-5 mt-10' and text()= 'Соберите бургер']");

    public AuthPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginToAccountButton(){
        driver.findElement(loginToAccountButton).click();
    }

    public By getOrderButton() {
        return orderButton;
    }

    public By getLoginButton() {
        return loginButton;
    }

    public By getPasswordField() {
        return passwordField;
    }

    public By getLoginLinkOnRegForm() {
        return loginLinkOnRegForm;
    }

    public By getLogoutButton() {
        return logoutButton;
    }

    public By getLkButton() {
        return lkButton;
    }

    public By getProfileHeader() {
        return profileHeader;
    }

    public void setLoginPassword(){
        driver.findElement(emailField).sendKeys(LOGIN);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(PASSWORD);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public boolean checkAuthorizationPassed(){
        return driver.findElement(orderButton).isDisplayed();
    }

    public void clickLkButton(){
        driver.findElement(lkButton).click();
    }

    public boolean checkLoginButtonIsPresent(){
        return driver.findElement(loginButton).isDisplayed();
    }

    public void clickLoginLinkOnRegForm(){
        driver.findElement(registrationLink).click();
        driver.findElement(loginLinkOnRegForm).click();
    }

    public void clickRecoverPasswordLinkForm(){
        driver.findElement(recoverPasswordLink).click();
    }

    public void clickLoginLinkOnRecoverPasswordForm(){
        driver.findElement(loginLinkOnRegForm).click();
    }

    public boolean checkProfileHeaderIsPresent(){
        return driver.findElement(profileHeader).isDisplayed();
    }

    public void clickConstructorButton(){
        driver.findElement(constructorButton).click();
    }

    public void clickLogoButton(){
        driver.findElement(logoButton).click();
    }

    public void clickLogoutButton(){
        driver.findElement(logoutButton).click();
    }

    public boolean checkAddBurgerHeaderIsPresent(){
        return driver.findElement(addBurgerHeader).isDisplayed();
    }
}
