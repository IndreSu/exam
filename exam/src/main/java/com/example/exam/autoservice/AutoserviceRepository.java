package com.example.exam.autoservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoserviceRepository extends JpaRepository<Autoservice, Long> {
//    @Query("SELECT DISTINCT m FROM Menu m LEFT JOIN FETCH m.meals")
//    List<Autoservice> findAllAutoservice();

}
