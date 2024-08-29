package com.qa.tests;

import com.qa.base.AppFactory;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductPage;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Objects;

public class LoginTest extends AppFactory {
    LoginPage loginpage;
    ProductPage productPage;
    InputStream inputStream;
    JSONObject loginUserjson;

    @BeforeClass
    public void setupDataStream() throws IOException {
        try {
            String dataFilePath = "data/loginusers.json";
            inputStream = getClass().getClassLoader().getResourceAsStream(dataFilePath);
            JSONTokener jsonTokener = new JSONTokener(Objects.requireNonNull(inputStream));
            loginUserjson = new JSONObject(jsonTokener);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    @BeforeMethod
    public void setup(Method method) {
        loginpage = new LoginPage();
        System.out.println("\n" + "**************** Tests Started: " + method.getName() + " ****************" + "\n");
    }

    @Test
    public void verifyUserLogin() throws InterruptedException {
        System.out.println("Login Test Started...");
        loginpage.enterusername(loginUserjson.getJSONObject("validuserlogin").getString("username"));
        loginpage.enterpassword(loginUserjson.getJSONObject("validuserlogin").getString("password"));
        productPage = loginpage.clickLoginbtn();

        String actualProductPageTitle = productPage.getTitle();
        String expectedProductTitle = "PRODUCTS";
        Assert.assertEquals(actualProductPageTitle, expectedProductTitle);
        System.out.println("Login Test Run Successfully...");
        Thread.sleep(3000);
    }
}
