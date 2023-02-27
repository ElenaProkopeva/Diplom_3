package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private WebDriver driver;
    //кнопка Войти в аккаунт
    private By loginToAccountButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text()= 'Войти в аккаунт']");
    //ссылка Зарегистрироваться
    private By registrationLinkOnLoginForm = By.xpath(".//div[@class='Auth_link__1fOlj' and text()= 'Зарегистрироваться']");
    //поле Имя
    private By nameField = By.xpath(".//body/div/div/main/div/form/fieldset[1]/div/div/input[@class='text input__textfield text_type_main-default' and @name='name']");
    //поле Email
    private By emailField = By.xpath(".//body/div/div/main/div/form/fieldset[2]/div/div/input[@class='text input__textfield text_type_main-default' and @name='name']");
    //поле Пароль
    private By passwordField = By.xpath(".//body/div/div/main/div/form/fieldset[3]/div/div/input[@class='text input__textfield text_type_main-default' and @name='Пароль']");
    //подсказка на некорректный пароль
    private By passwordError = By.xpath(".//body/div/div/main/div/form/fieldset[3]/div/p[@class='input__error text_type_main-default' and text()= 'Некорректный пароль']");
    //кнопка Зарегистрироваться
    private By registrationButton = By.xpath(".//body/div/div/main/div/form/button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text()= 'Зарегистрироваться']");
    //элемент подтверждения успешной регистрации - заголовок Вход
    private By loginHeader = By.xpath(".//body/div/div/main/div/h2");
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getEmailField() {
        return emailField;
    }

    public By getPasswordError() {
        return passwordError;
    }

    public By getLoginHeader() {
        return loginHeader;
    }

    public By getRegistrationButton() {
        return registrationButton;
    }

    public void clickLoginToAccountButton(){
        driver.findElement(loginToAccountButton).click();
    }

    public void setRegistrationData(String name, String email, String password){
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickRegistrationButton(){
        driver.findElement(registrationButton).click();
    }

    public boolean checkPasswordIsCorrect(String password){
        return password.length() >= 6;
    }

    public boolean checkPasswordErrorIsDisplayed(){
        System.out.println(driver.findElement(passwordError).toString());
        System.out.println(driver.findElement(passwordError).isEnabled());
        System.out.println(driver.findElement(passwordError).isDisplayed());
        return driver.findElement(passwordError).isDisplayed() ? true : false;
    }

    public String checkPasswordErrorText(){
        return driver.findElement(passwordError).getText();
    }

    public boolean checkRegistrationPassed(){
        return driver.findElement(loginHeader).isDisplayed();
    }
}
