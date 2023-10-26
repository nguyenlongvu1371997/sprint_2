package com.example.final_exam.repository;

import com.example.final_exam.model.Positions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionsRepository extends JpaRepository<Positions, Long> {
}
