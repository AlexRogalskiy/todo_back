package hello;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {

//    Iterable<Task> findTop3OrOrderByName();

}
