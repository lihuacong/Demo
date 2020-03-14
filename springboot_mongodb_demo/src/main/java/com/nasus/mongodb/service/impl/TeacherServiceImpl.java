package com.nasus.mongodb.service.impl;

import com.nasus.mongodb.constants.Constants;
import com.nasus.mongodb.domain.Teacher;
import com.nasus.mongodb.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Project Name:springboot_mongodb_demo <br/>
 * Package Name:com.nasus.mongodb.service.impl <br/>
 * Date:2019/3/9 17:23 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 添加学生信息
     *
     * @param teacher
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Teacher addTeacher(Teacher teacher) {
        return mongoTemplate.save(teacher);
    }

    /**
     * 根据 id 删除学生信息
     *
     * @param id
     */
    @Override
    public void deleteTeacher(String id) {

        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, Constants.TEACHER_COLLECTION_NAME);
    }

    /**
     * 更新学生信息
     *
     * @param teacher
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Teacher updateTeacher(Teacher teacher) {
        Teacher oldTeacher = this.findTeacherById(teacher.getId());
        if (oldTeacher != null) {
            oldTeacher.setAge(teacher.getAge());
            oldTeacher.setName(teacher.getName());
            oldTeacher.setGender(teacher.getGender());
            return mongoTemplate.save(oldTeacher);
        } else {
            return null;
        }
    }

    /**
     * 根据 id 查询学生信息
     *
     * @param id
     * @return
     */
    @Override
    public Teacher findTeacherById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        List<Teacher> teachers = mongoTemplate.find(query, Teacher.class);
        if (CollectionUtils.isEmpty(teachers)) {
            return null;
        }
        return teachers.get(0);
    }

    /**
     * 查询学生信息列表
     *
     * @return
     */
    @Override
    public List<Teacher> findAllTeacher() {
        return mongoTemplate.findAll(Teacher.class);
    }
}
