package in.ineuron.service;

import in.ineuron.daofactory.DaoServiceFactory;
import in.ineuron.dto.Student;
import in.ineuron.persistence.IStudentDao;

public class StudentServiceImpl implements IStudentService {

	IStudentDao daoservice = null;

	@Override
	public String addStudent(String sname, Integer sage, String saddress) {

		daoservice = DaoServiceFactory.getDaoService();
		return daoservice.addStudent(sname, sage, saddress);
	}

	@Override
	public Student searchStudent(Integer sid) {
		daoservice = DaoServiceFactory.getDaoService();

		return daoservice.searchStudent(sid);

	}

	@Override
	public String deleteStudent(Integer sid) {
		daoservice = DaoServiceFactory.getDaoService();
		return daoservice.deleteStudent(sid);
	}

	@Override
	public String updateStudent(Student student) {
		daoservice = DaoServiceFactory.getDaoService();
		return daoservice.updateStudent(student);
	}

}
