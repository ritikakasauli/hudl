
package tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.hudl.common.Utils;
import com.hudl.dataprovider.DataProvider;
import com.hudl.pages.DashboardPage;
import com.hudl.pages.HomePage;
import com.hudl.pages.LoginPage;
import com.hudl.pages.VideoUploadPage;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Ritika
 */
public class BasicTest
{
    LoginPage lPage = null;
    HomePage hPage = null;
    DashboardPage dbPage = null;
    VideoUploadPage vuPage = null;

    
    @Test
    public void uploadTest() 
    {
        
        hPage.clickLoginLink();

        lPage.setUserNameField(DataProvider.userName);
        lPage.setPasswordField(DataProvider.password);
        lPage.clickLoginButton();
        
        dbPage.clickUploadButton();
        
        vuPage.selectFiles(DataProvider.videoPath, 120, "Test");
    }

    @org.testng.annotations.BeforeClass
    public void setUpClass() throws Exception
    {
        Utils.getDriver().get(DataProvider.URL);
        lPage = new LoginPage();
        hPage = new HomePage();
        dbPage = new DashboardPage();
        vuPage = new VideoUploadPage();
        
    }

    @org.testng.annotations.AfterClass
    public static void tearDownClass() throws Exception
    {
    }

    @org.testng.annotations.BeforeMethod
    public void setUpMethod() throws Exception
    {
        
    }

    @org.testng.annotations.AfterMethod
    public void tearDownMethod() throws Exception
    {
    }
}
