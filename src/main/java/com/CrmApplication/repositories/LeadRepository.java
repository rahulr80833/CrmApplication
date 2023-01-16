package com.CrmApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CrmApplication.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead,Long> {

}
