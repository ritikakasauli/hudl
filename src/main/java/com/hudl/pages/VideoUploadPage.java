/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hudl.pages;

import com.hudl.common.Utils;
import com.hudl.common.report.Reporter;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Ritika
 */
public class VideoUploadPage
{

    private WebElement selectBtn = null;

    private WebElement uploadSomethingBtn = null;

    private WebElement watchVideoButton = null;

            
    public void selectFiles(String path, long maxWaitInSec, String videoTitle)
    {
        try
        {
            selectBtn = Utils.getDriver().findElement(By.id("web-uploader-app")).findElement(By.tagName("button"));

            do
            {
                try
                {
                    selectBtn.click();
                    Thread.sleep(2000);
                    Utils.copyAndPaste(path);
                    Thread.sleep(1000);
                    Utils.hitEnter();
                    Thread.sleep(1000);
                }
                catch(Exception ex)
                {
                }
            }while(!isUploadSomethingElseButtonDisplayed());

            Reporter.reportPass("Select files clicked.");
            int maxTries = 10;
            int cnt = 0;
            boolean uploadComplete = false;
            do
            {
                cnt++;
                try
                {
                    watchVideoButton = Utils.getDriver().findElement(By.linkText("Watch Video"));
                    watchVideoButton.getTagName();
                    uploadComplete = true;
                }
                catch(Exception ex)
                {
                    
                }
            }while((!uploadComplete)&&(maxTries>cnt));
            Reporter.reportPass("File uploaded and shared.");
        }
        catch(Exception ex)
        {
            Reporter.reportFail("Cloud not click Select files button. Error: "+ex);
        }
    }

    private boolean isUploadSomethingElseButtonDisplayed()
    {
        try
        {
            uploadSomethingBtn = Utils.getDriver().findElement(By.linkText("Upload Something Else"));
            uploadSomethingBtn.isDisplayed();
            return true;
        }
        catch(Exception ex)
        {
        }
        return false;
    }
}
