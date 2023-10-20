package edu.icet.service;

import edu.icet.dao.GuardianEntity;
import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;

import java.util.ArrayList;
import java.util.List;

public interface StudentService {

    void registerStudent(Student student);

    List<Student> retrieveAllStudents();



    Iterable<StudentEntity> retrieveStudentByAddress(String name);
}

//test commit
//test commit second commit