package com.example.repositories;

import com.example.models.Task;
import com.example.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t   WHERE  t.DueDate = :dueDate")
    List<Task> findTasksByDueDate( @Param("dueDate") Date dueDate);
    @Query("SELECT t FROM Task t JOIN t.users u WHERE u = :user AND t.DueDate = :dueDate")
    List<Task> findTasksByUserAndDueDate(@Param("user") User user, @Param("dueDate") Date dueDate);
    @Query("SELECT t FROM Task t JOIN t.users u WHERE u = :user")
    List<Task> findTasksByUser(@Param("user") User user);
    @Query("SELECT t FROM Task t WHERE  t.DueDate >= :startDate AND t.DueDate <= :endDate")
    List<Task> findTasksByPeriod( @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT t FROM Task t JOIN t.users u WHERE u = :user AND t.DueDate >= :startDate AND t.DueDate <= :endDate")
    List<Task> findTasksByUserAndPeriod(@Param("user") User user, @Param("startDate") Date startDate, @Param("endDate") Date endDate);


}

