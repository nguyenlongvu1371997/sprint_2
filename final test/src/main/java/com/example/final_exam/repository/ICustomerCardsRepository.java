package com.example.final_exam.repository;

import com.example.final_exam.model.CustomerCards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerCardsRepository extends JpaRepository<CustomerCards, Long> {
}
