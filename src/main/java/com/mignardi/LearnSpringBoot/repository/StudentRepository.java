package com.mignardi.LearnSpringBoot.repository;

import com.mignardi.LearnSpringBoot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByEmail (String email);
    List<Student> findByName (String name);
    @Query("SELECT s FROM Student s WHERE s.email LIKE %:domain")
    List<Student> findByDomain (@Param("domain") String domain);
}
