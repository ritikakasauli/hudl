/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hudl.common;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Ritika
 */
public class Utils
{
    private static WebDriver dr = null;
    private static long timeout = 30;
    public static WebDriver getDriver()
    {
        if(dr==null)
        {
            System.setProperty("webdriver.gecko.driver","src/main/resources/driver/geckodriver.exe");
            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            dr = new FirefoxDriver();
            dr.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        }
        return dr;
    }
    
    public static String getDateTimeStamp()
    {
        return (new Date()).toGMTString();
    }

    public static void hitEnter()
    {
        try
        {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ENTER);
        }
        catch(Exception ex)
        {
            
        }
    }

    public static void copyAndPaste(String text)
    {
        try
        {
            StringSelection selection = new StringSelection(text);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, selection);
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_V);
        }
        catch(Exception ex)
        {
            
        }
    }

}
