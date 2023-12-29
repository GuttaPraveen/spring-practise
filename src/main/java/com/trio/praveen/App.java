package com.trio.praveen;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.trio.praveen.configuration.StudentConfiguration;
import com.trio.praveen.dao.StudentDao;
import com.trio.praveen.dao.StudentDaoImpl;
import com.trio.praveen.entity.Student;

public class App 
{
    public static void main( String[] args )
    {
    	 AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext();
    	 context.register(StudentConfiguration.class);
    	 context.refresh();
    	 
    	 StudentDao studentDao = (StudentDao)context.getBean(StudentDaoImpl.class);
         Student student =new Student();
         
         //create or add
         student.setStudentId("1240");
         student.setStudentName("Praveen");
         student.setStudentAddress("Vijayawada");
         
         //update
         Student student2=studentDao.getDetails("1240");
         student2.setStudentId("1318");
         student2.setStudentName("Maha");
         student2.setStudentAddress("Guntur");
         
         //get or read
         Student student3=studentDao.getAllDetails();
         System.out.println(student3);
         //delete
         studentDao.deleteStudent("1318");
         
        
    }
}
