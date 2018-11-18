/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hudl.common.report;

import com.hudl.common.Utils;

/**
 *
 * @author Ritika
 */

public class Reporter
{
    
    public static void reportPass(String msg)
    {
        System.out.println("[PASS]\t"+Utils.getDateTimeStamp()+"\t"+msg);
    }
    
    public static void reportInfo(String msg)
    {
        System.out.println("[INFO]\t"+Utils.getDateTimeStamp()+"\t"+msg);
    }

    public static void reportFail(String msg)
    {
        System.out.println("[FAIL]\t"+Utils.getDateTimeStamp()+"\t"+msg);
    }

}
