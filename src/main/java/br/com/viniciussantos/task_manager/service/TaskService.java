package br.com.viniciussantos.task_manager.service;


import br.com.viniciussantos.task_manager.model.Task;
import br.com.viniciussantos.task_manager.repository.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserService userService;

    public TaskService(TaskRepository taskRepository, UserService userService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(String id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void completeTask(String id) {
        var task = this.findById(id);
        task.setCompleted(Boolean.TRUE);
        taskRepository.save(task);
    }

    public Task save(Task task) {
        var user = userService.findById(task.getUser().getId());
        task.setUser(user);
        return taskRepository.save(task);
    }

    public Task update(Task task) {
        var taskEntity = this.findById(task.getId());
        BeanUtils.copyProperties(task, taskEntity, "id");
        return taskRepository.save(taskEntity);
    }
    public void delete(String id) {
        taskRepository.deleteById(id);
    }

}
