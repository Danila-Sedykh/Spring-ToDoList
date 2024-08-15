package example.Spring_ToDoList.service;

import example.Spring_ToDoList.models.Task;
import example.Spring_ToDoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElse(null);
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task taskDetails){
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null){
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setDate(taskDetails.getDate());
            task.setStatus(taskDetails.getStatus());
            return taskRepository.save(task);
        }
        return null;
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
}
