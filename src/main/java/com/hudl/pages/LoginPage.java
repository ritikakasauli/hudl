/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hudl.pages;

import com.hudl.common.Utils;
import com.hudl.common.report.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Ritika
 */
public class LoginPage
{
    private WebElement usrNameField = null;
    private WebElement passwordField = null;
    private WebElement loginBtn = null;

    public void setUserNameField(String value)
    {
        try
        {
            usrNameField = Utils.getDriver().findElement(By.id("email"));
            usrNameField.sendKeys(value);
            Reporter.reportPass("Username entered.");
        }
        catch(Exception ex)
        {
            Reporter.reportFail("Cloud not enter user name. Error: "+ex);
        }
    }

    public void setPasswordField(String value)
    {
        try
        {
            passwordField = Utils.getDriver().findElement(By.id("password"));
            passwordField.sendKeys(value);
            Reporter.reportPass("Password entered.");
        }
        catch(Exception ex)
        {
            Reporter.reportFail("Cloud not enter password. Error: "+ex);
        }
    }

    public void clickLoginButton()
    {
        try
        {
            loginBtn = Utils.getDriver().findElement(By.id("logIn"));
            loginBtn.click();
            Reporter.reportPass("Login button clicked.");
        }
        catch(Exception ex)
        {
            Reporter.reportFail("Cloud not click Login button.");
        }
    }
    
}
