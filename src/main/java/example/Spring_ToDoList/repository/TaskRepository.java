package example.Spring_ToDoList.repository;

import example.Spring_ToDoList.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Override
    List<Task> findAll();

    @Override
    <S extends Task> S save(S entity);

    @Override
    Optional<Task> findById(Long aLong);

    @Override
    void deleteById(Long aLong);

}
