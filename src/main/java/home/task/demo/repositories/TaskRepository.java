package home.task.demo.repositories;

import home.task.demo.models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface TaskRepository extends MongoRepository<Task, Long> {
    void deleteTaskById(Long id);
    Optional<Task> findTaskById(Long id);

}
