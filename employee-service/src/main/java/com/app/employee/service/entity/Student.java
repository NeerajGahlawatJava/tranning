package com.app.employee.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @EmbeddedId
    private StudentIdentity studentIdentity;
    private String name;
    private String course;

}
