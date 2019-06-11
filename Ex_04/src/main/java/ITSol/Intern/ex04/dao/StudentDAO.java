package ITSol.Intern.ex04.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ITSol.Intern.ex04.model.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer>{
	@Query("select e from Student e where name like ?1")
	List<Student> findStudentByName(String name);
	
	@Query("select e from Student e where classs = ?1")
	List<Student> filterClass(String classs);
}
