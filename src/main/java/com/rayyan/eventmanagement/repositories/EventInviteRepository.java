package com.rayyan.eventmanagement.repositories;

import com.rayyan.eventmanagement.model.EventInvites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventInviteRepository extends JpaRepository<EventInvites, Long> {

}
