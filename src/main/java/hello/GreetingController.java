package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private TaskRepository taskRepository;

    @Autowired
    public GreetingController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @CrossOrigin(origins = "http://localhost:3001")
    @GetMapping("/tasks")
    public List<Task> getClientList() {
        List<Task> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(tasks::add);

        return tasks;
    }

    @RequestMapping("task")
    public ResponseEntity<Task> getTaskById(@RequestParam(value="id") Integer id) {
        long longId = id;
        Task task = taskRepository.findById(longId).get();
        return new ResponseEntity<Task>(task, HttpStatus.OK);
    }
}