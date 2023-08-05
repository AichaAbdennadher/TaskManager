package com.example.repositories;

import com.example.models.LogTime;
import com.example.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogTimeRepository extends JpaRepository<LogTime, Long> {

}

