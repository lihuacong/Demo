package com.nasus.mongodb.service;

import com.nasus.mongodb.domain.Teacher;
import com.nasus.mongodb.domain.Teacher;

import java.util.List;

/**
 * Project Name:springboot_mongodb_demo <br/>
 * Package Name:com.nasus.mongodb.service <br/>
 * Date:2019/3/9 17:18 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
public interface TeacherService {

    Teacher addTeacher(Teacher student);

    void deleteTeacher(String id);

    Teacher updateTeacher(Teacher student);

    Teacher findTeacherById(String id);

    List<Teacher> findAllTeacher();

}
