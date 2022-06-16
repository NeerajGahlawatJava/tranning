package com.app.employee.service.repository;

import com.app.employee.service.entity.Student;
import com.app.employee.service.entity.StudentIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, StudentIdentity> {
}
