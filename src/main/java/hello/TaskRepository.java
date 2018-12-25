package hello;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {

//    Iterable<Task> findTop3OrOrderByName();

    List<Task> findAllByIsUrgentOrIsUrgent(@Param("isUrgent1") Integer isUrgent1,
                                           @Param("isUrgent2") Integer isUrgent2,
                                           Pageable pageable);

}
