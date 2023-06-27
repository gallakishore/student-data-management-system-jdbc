package in.ineuron.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineuron.dto.Student;
import in.ineuron.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao {

	Connection connection=null;
	PreparedStatement pstmt=null;
	ResultSet resultSet=null;
	
	@Override
	public String addStudent(String sname, Integer sage, String saddress) 
	{
		try {
			
			connection=JdbcUtil.getJdbcConnection();
			if(connection!=null)
			{
				String sqlInsertQuery="insert into student(`sname`,`sage`,`saddress`) values(?,?,?)";
				pstmt = connection.prepareStatement(sqlInsertQuery);
			}
			
			if(pstmt!=null)
			{
				pstmt.setString(1,sname);
				pstmt.setInt(2,sage);
				pstmt.setString(3,saddress);
				
				int rowAffected=pstmt.executeUpdate();
				if(rowAffected==1)
				{
					return "success";
				}
			}
			
			
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return "failure";
	}

	@Override
	public Student searchStudent(Integer sid) {
		String sqlInsertQuery="select sid,sname,sage,saddress from student where sid=?";
		Student student=null;
		try{	
			connection=JdbcUtil.getJdbcConnection();
			if(connection!=null)
			{
				
				pstmt = connection.prepareStatement(sqlInsertQuery);
			}
			
			if(pstmt!=null)
			{
				pstmt.setInt(1,sid);
				resultSet=pstmt.executeQuery();
					
			}
			if(resultSet!=null)
			{
				if(resultSet.next())
				{
					student =new Student();
					
					student.setSid(resultSet.getInt(1));
					student.setSname(resultSet.getString(2));
					student.setSage(resultSet.getInt(3));
					student.setSaddress(resultSet.getString(4));
					
					return student;
				}
				
			}
		
         }
		catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}catch(Exception e)
         {
        	 e.printStackTrace();
        	 return student;
         }
		
	
		return student;
	}


	@Override
	public String deleteStudent(Integer sid) {
		
		try {
			connection=JdbcUtil.getJdbcConnection();
			if(connection!=null)
			{
				String sqlInsertQuery="delete from  student where sid=?";
				pstmt = connection.prepareStatement(sqlInsertQuery);
			}
			
			if(pstmt!=null)
			{
				pstmt.setInt(1,sid);
				
				int rowAffected=pstmt.executeUpdate();
				if(rowAffected==1)
				{
					return "success";
				}
				else
				{
					return "failure";
				}
			}
			
					
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
			return "failure";
		}     
		return "failure";
	}

	@Override
	public String updateStudent(Student student) {
		
        try {
			connection=JdbcUtil.getJdbcConnection();
			if(connection!=null)
			{
				String sqlInsertQuery="update student set sname=?,sage=?,saddress=? where sid=?";
				pstmt = connection.prepareStatement(sqlInsertQuery);
			}
			
			if(pstmt!=null)
			{
				pstmt.setString(1,student.getSname());
				pstmt.setInt(2,student.getSage());
				pstmt.setString(3,student.getSaddress());
				pstmt.setInt(4,student.getSid());
				
				int rowAffected=pstmt.executeUpdate();
				if(rowAffected==1)
				{
					return "success";
				}
			}
					
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
			return "failure";
		}     
		return "failure";
	}

}
