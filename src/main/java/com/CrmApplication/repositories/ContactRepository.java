package com.CrmApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CrmApplication.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact,Long> {

}
