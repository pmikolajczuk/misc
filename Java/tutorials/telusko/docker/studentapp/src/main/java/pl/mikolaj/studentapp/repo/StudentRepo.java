package pl.mikolaj.studentapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mikolaj.studentapp.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}
