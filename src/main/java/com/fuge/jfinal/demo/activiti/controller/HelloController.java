package com.fuge.jfinal.demo.activiti.controller;

import com.jfinal.core.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO.
 * <p>
 * User: sujie
 * Date: 2019/1/17
 * Time: 12:43 PM
 */
public class HelloController extends Controller
{
    public void hello()
    {

        List<Demo> demoList = new ArrayList<>();
        demoList.add(new Demo("Hello"));
        demoList.add(new Demo("Hello Spring"));
        demoList.add(new Demo("Hello Spring Boot"));

        renderJson(demoList);
    }

    public void helloArray(){
        List<String> demoList = new ArrayList<>();
        demoList.add("hello1");
        demoList.add("hello2");
        demoList.add("hello3");

        renderJson(demoList);
    }
}

