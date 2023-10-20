package edu.icet.service;
import edu.icet.dao.GuardianEntity;
import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;
import edu.icet.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Primary
public class StudentServiceImpl implements StudentService{

    /*@Value("${institute.name}")
    String instituteName;*/

    @Autowired
    StudentRepository studentRepository;


    public void registerStudent(Student student){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(student.getName());
        studentEntity.setAge(student.getAge());;
        studentEntity.setContact(student.getContact());
        studentRepository.save(studentEntity);
    }

    public List<Student> retrieveAllStudents(){

        Iterable<StudentEntity> studentList =  studentRepository.findAll();
        List<Student> studentModelList = new ArrayList();

        Iterator<StudentEntity> iterator = studentList.iterator();

        while(iterator.hasNext()){
            StudentEntity studentDao = iterator.next();

            //Model Mapping
            Student studentDto = Student.builder()
                    .name(studentDao.getName())
                    .age(studentDao.getAge())
                    .contact(studentDao.getContact())
                    .build();

            studentModelList.add(studentDto);
        }
        return studentModelList;
    }

    public Iterable<StudentEntity> retrieveStudentByAddress(String name){
        return studentRepository.findAllByName(name);
    }


}
