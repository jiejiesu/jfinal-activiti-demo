package com.fuge.jfinal.demo.activiti.controller;

import com.fuge.jfinal.demo.activiti.ActivitiKit;
import com.jfinal.core.Controller;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/**
 * TODO.
 * <p>
 * User: sujie
 * Date: 2019/1/3
 * Time: 2:56 PM
 */
public class IndexController extends Controller
{

    public void index(){
        renderText("Hello， I am  Sujie！");
    }

    public void start()
    {
        ProcessInstance pi = ActivitiKit.startProcessInstanceByKey("firstProcess");
        renderJson(pi.getId());

    }

    public void getTaskName()
    {
        String processInstanceId = getPara("id");

        Task testTask = ActivitiKit.getTask(processInstanceId);

        renderJson(testTask == null ? null : testTask.getName());
    }


    public void completeTask()
    {
        String processInstanceId = getPara("id");

        Task testTask = ActivitiKit.getTask(processInstanceId);

        testTask = ActivitiKit.completeTask(testTask);

        renderJson(testTask == null ? null : testTask.getName());
    }

}
