package com.example.hrmanagment.repository;

import com.example.hrmanagment.entity.Task;
import com.example.hrmanagment.entity.enums.TaskState;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> getTaskByStateAndResponsibleEmployeeId(TaskState state, UUID responsibleId);
}
