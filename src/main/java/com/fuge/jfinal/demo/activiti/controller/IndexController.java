package com.fuge.jfinal.demo.activiti.controller;

import io.jboot.app.JbootApplication;
import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;

/**
 * TODO.
 * <p>
 * User: sujie
 * Date: 2019/1/3
 * Time: 2:56 PM
 */
@RequestMapping("/")
public class IndexController extends JbootController
{

    public void index(){
        renderText("Hello Sujie");
    }

//    public void start()
//    {
//        ProcessInstance pi = ActivitiKit.startProcessInstanceByKey("firstProcess");
//        renderJson(pi.getId());
//
//    }
//
//    public void getTaskName()
//    {
//        String processInstanceId = getPara("id");
//
//        Task testTask = ActivitiKit.getTask(processInstanceId);
//
//        renderJson(testTask == null ? null : testTask.getName());
//    }
//
//
//    public void completeTask()
//    {
//        String processInstanceId = getPara("id");
//
//        Task testTask = ActivitiKit.getTask(processInstanceId);
//
//        testTask = ActivitiKit.completeTask(testTask);
//
//        renderJson(testTask == null ? null : testTask.getName());
//    }

    public static void main(String[] args)
    {
        JbootApplication.run(args);
    }
}
