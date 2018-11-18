/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hudl.pages;

import com.hudl.common.report.Reporter;
import com.hudl.common.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Ritika
 */

public class HomePage
{
    private WebElement loginLink = null;

    public void clickLoginLink()
    {
        try
        {
            loginLink = Utils.getDriver().findElement(By.linkText("Log in"));
            loginLink.click();
            Reporter.reportPass("Login button clicked.");
        }
        catch(Exception ex)
        {
            Reporter.reportFail("Cloud not click Login button.");
        }
    }
}
