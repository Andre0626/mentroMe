package com.mentorme.mentor.repository;

import com.mentorme.mentor.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepo extends JpaRepository<Participant,Long> {
}
