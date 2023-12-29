package com.trio.praveen.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.trio.praveen.entity.Student;

public class StudentDaoImpl implements StudentDao
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	public Student getAllDetails()
	{
		
		StudentRowMapper rowMapper = new StudentRowMapper();
		String sql = "select * from student";
		Student student = jdbcTemplate.queryForObject(sql,rowMapper);
		return student;
	}

	public Student getDetails(String studentId)
	{
		
		StudentRowMapper rowMapper = new StudentRowMapper();
		String sql = "select * from student where studentId=?";
		Student student = jdbcTemplate.queryForObject(sql,rowMapper,studentId);
		return student;
		
	}

	public String addStudent(Student student) 
	{
		String query = "insert into student values(?,?,?)";
		
		int rowCount=jdbcTemplate.update(query,student.getStudentId(),student.getStudentName(),student.getStudentAddress());
		if(rowCount>1)
		{
			return "Student Details inserted SuccessFully";
		}
		else
		{
			return "Failure insertion of Student Details";
		}
	}

	public String deleteStudent(String studentId)
	{
		
		String query = "delete from student where studentId=?";
		int rowCount=jdbcTemplate.update(query,studentId);
		if(rowCount>1)
		{
			return "Student  record deleted Successfully";
		}
		else
		{
			return "Failure delete of Student record";
		}
	}

	public String updateStudent(Student student) 
	{
		
		String sql = "update student set studentId=?, studentName=?,studentAddress=?";
		int rowCount = jdbcTemplate.update(sql,student.getStudentId(),student.getStudentName(),student.getStudentAddress());
		if(rowCount>1)
		{
			return "Student  record updated Successfully";
		}
		else
		{
			return "Failure updation of Student record";
		}
	}

}
