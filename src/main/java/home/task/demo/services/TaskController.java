package home.task.demo.services;

import home.task.demo.models.Task;
import home.task.demo.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable long id) {
        taskRepository.deleteTaskById(id);
    }

    @GetMapping("/admins/{id}")
    public Task retrieveTask(@PathVariable long id) {

        Optional<Task> task = taskRepository.findTaskById(id);
        if (!task.isPresent())
            throw new RuntimeException("task could not found for this id" + id);
        return task.get();
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<Object> updateTask(@RequestBody Task task, @PathVariable long id) {

        Optional<Task> taskOptional = taskRepository.findTaskById(id);

        if (!taskOptional.isPresent())  return ResponseEntity.notFound().build();

        task.setId(id);
        taskRepository.save(task);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/task")
    public void addAdmin(@RequestBody Task task){
        taskRepository.save(task);
    }

}
