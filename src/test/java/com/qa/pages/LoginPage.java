package com.qa.pages;

import com.qa.base.AppDriver;
import com.qa.base.AppFactory;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AppFactory {
    public LoginPage() {
        System.out.println("Inside Login Ctor...");
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
        System.out.println("Outside Login Ctor...");
    }

    @AndroidFindBy(accessibility = "test-Username")
    public WebElement txtusername;

    @AndroidFindBy(accessibility = "test-Password")
    public WebElement txtpassword;

    @AndroidFindBy(accessibility = "test-LOGIN")
    public WebElement btnlogin;

    //Waiting for the SwagLapHeader before input the username and password
    public void enterusername(String username) {
        sendKeys_(txtusername, username);
    }

    public void enterpassword(String password) {
        sendKeys_(txtpassword,password);

    }

    public ProductPage clickLoginbtn() {
        clickElement(btnlogin);
        return new ProductPage();
        //return type is Product, so once the user click on the login button, Product page will be redirected.
    }
}
