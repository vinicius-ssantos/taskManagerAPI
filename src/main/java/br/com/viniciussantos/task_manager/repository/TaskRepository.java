package br.com.viniciussantos.task_manager.repository;


import br.com.viniciussantos.task_manager.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<Task, String>{
}
