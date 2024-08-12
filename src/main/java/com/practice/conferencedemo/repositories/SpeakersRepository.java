package com.practice.conferencedemo.repositories;

import com.practice.conferencedemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakersRepository extends JpaRepository<Speaker, Long> {
}
