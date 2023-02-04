package com.tpe.repository;

import com.tpe.domain.Student;
import com.tpe.dto.StudentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {
    boolean existsByEmail(String email);

    List<Student> findByLastName(String lastName);

    //JPQL ******************
    @Query("SELECT s FROM Student s WHERE s.grade =:pGrade")
    List<Student> findByStudentByGrade(@Param("pGrade") Integer grade);

    //Native SQL query
    @Query(value="SELECT * FROM student s WHERE s.grade =:pGrade", nativeQuery = true)
    List<Student> findByStudentByGradeWithSQL(@Param("pGrade") Integer grade);

    @Query("SELECT new com.tpe.dto.StudentDTO(s) FROM Student s WHERE s.id=:id")

    Optional<StudentDTO> findStudentDTOById(@Param("id") Long id);
}