package com.dailycodebuffer.springboot.tutorial.repository;

import com.dailycodebuffer.springboot.tutorial.entity.Hod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HodRepository extends JpaRepository<Hod, Long> {
}