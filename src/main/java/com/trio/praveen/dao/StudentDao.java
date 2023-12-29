package com.trio.praveen.dao;

import com.trio.praveen.entity.Student;

public interface StudentDao
{
	public Student getAllDetails();
	public Student getDetails(String tudentId);
	public String addStudent(Student student);
	public String deleteStudent(String studentId);
	public String updateStudent(Student student);
}
