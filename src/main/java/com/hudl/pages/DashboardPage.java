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
public class DashboardPage
{

    private WebElement uploadBtn = null;

    public void clickUploadButton()
    {
        try
        {
            uploadBtn = Utils.getDriver().findElement(By.linkText("Upload"));
            uploadBtn.click();
            Reporter.reportPass("Upload clicked.");
        }
        catch(Exception ex)
        {
            Reporter.reportFail("Cloud not click upload button. Error: "+ex);
        }
    }

}
