package br.com.viniciussantos.task_manager.repository;

import br.com.viniciussantos.task_manager.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
