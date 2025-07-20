package com.rayyan.eventmanagement.repositories;

import com.rayyan.eventmanagement.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
