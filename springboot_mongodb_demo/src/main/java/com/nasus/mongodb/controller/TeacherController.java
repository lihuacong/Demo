package com.nasus.mongodb.controller;

import com.nasus.mongodb.domain.Teacher;
import com.nasus.mongodb.service.TeacherService;
import com.nasus.mongodb.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Project Name:springboot_mongodb_demo <br/>
 * Package Name:com.nasus.mongodb.controller <br/>
 * Date:2019/3/9 17:43 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/add")
    public Teacher addTeacher(@RequestBody Teacher student){
        return teacherService.addTeacher(student);
    }

    @PutMapping("/update")
    public Teacher updateTeacher(@RequestBody Teacher student){
        return teacherService.updateTeacher(student);
    }

    @GetMapping("/{id}")
    public Teacher findTeacherById(@PathVariable("id") String id){
        return teacherService.findTeacherById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacherById(@PathVariable("id") String id){
        teacherService.deleteTeacher(id);
    }

    @GetMapping("/list")
    public List<Teacher> findAllTeacher(){
        return teacherService.findAllTeacher();
    }

}
