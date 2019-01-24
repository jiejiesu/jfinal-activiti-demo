package com.fuge.jfinal.demo.activiti.controller;

import java.io.Serializable;

/**
 * TODO.
 * <p>
 * User: sujie
 * Date: 2019/1/17
 * Time: 12:54 PM
 */
public class Demo  implements Serializable
{
    String key = "key";
    String value;

    public Demo(String value)
    {
        this.value = value;
    }

    public Demo(String key, String value)
    {
        this.key = key;
        this.value = value;
    }

    public String getKey()
    {
        return key;
    }

    public String getValue ()
    {
        return value;
    }
}
