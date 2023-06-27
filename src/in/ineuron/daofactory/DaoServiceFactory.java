package in.ineuron.daofactory;

import in.ineuron.persistence.IStudentDao;
import in.ineuron.persistence.StudentDaoImpl;

public class DaoServiceFactory {
	
	private DaoServiceFactory(){
		
	}
	
	private static IStudentDao studentDao=null;
	
	public static IStudentDao getDaoService()
	{
		if(studentDao==null)
		{
			
			studentDao=new StudentDaoImpl();
		}
		
		return  studentDao;
	}

}
