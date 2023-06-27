package in.ineuron.servicefactory;

import in.ineuron.service.IStudentService;
import in.ineuron.service.StudentServiceImpl;

public class StudentServiceFactory 
{

	private StudentServiceFactory() {
		
	}
	public static IStudentService studentService=null;
	
	public static IStudentService getStudentsService()
	{
		if(studentService==null)
		{
			studentService=new StudentServiceImpl();			
		}
		
		return studentService;
		
	}
}
