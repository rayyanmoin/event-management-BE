package com.rayyan.eventmanagement.repositories;

import com.rayyan.eventmanagement.model.EventTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTemplateRepository extends JpaRepository<EventTemplate,Long> {

    EventTemplate findByName(String name);

}

