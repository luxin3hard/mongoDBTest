package com.mongodb;

/**
 * @author: hzxyap
 * @time: 2016/6/16 Time: 16:29
 * @description：
 * @project: rocTest
 */
public class TestMain
{
    public void sysout(String ...strings){
        for (String str:strings){
            System.out.println(str);
        }
    }
    public static void main(String[] args)
    {
        TestMain testMain=new TestMain();
        String[] strArray={"abc","bcd"};
        testMain.sysout(strArray);
    }
}
