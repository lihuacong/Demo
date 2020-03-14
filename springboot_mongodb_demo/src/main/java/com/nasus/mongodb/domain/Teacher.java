package com.nasus.mongodb.domain;

import com.nasus.mongodb.constants.Constants;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Project Name:springboot_mongodb_demo <br/>
 * Package Name:com.nasus.mongodb.domain <br/>
 * Date:2019/3/9 17:13 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Data
@Document(collection = Constants.TEACHER_COLLECTION_NAME)
public class Teacher {

    @Id
    private String id;

    private Integer age;

    private String name;

    private String gender;

    @Field("students")
    private List<Student> studentList;

}
