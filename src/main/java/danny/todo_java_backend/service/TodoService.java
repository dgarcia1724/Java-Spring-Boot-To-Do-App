package danny.todo_java_backend.service;

import danny.todo_java_backend.model.Todo;
import danny.todo_java_backend.repository.TodoRepository;
import danny.todo_java_backend.exception.TodoNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor    // Lombok: generates constructor for final fields
@Slf4j                     // Lombok: adds logging capability
public class TodoService {
    private final TodoRepository todoRepository;

    public Todo createTodo(Todo todo) {
        log.info("Creating new todo: {}", todo.getTitle());
        return todoRepository.save(todo);
    }

    public List<Todo> getAllTodos() {
        log.info("Fetching all todos");
        return todoRepository.findAll();
    }

    public Todo getTodoById(Long id) {
        log.info("Fetching todo with id: {}", id);
        return todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found with id: " + id));
    }

    public Todo updateTodo(Long id, Todo todoDetails) {
        log.info("Updating todo with id: {}", id);
        Todo existingTodo = getTodoById(id);
        
        existingTodo.setTitle(todoDetails.getTitle());
        existingTodo.setDescription(todoDetails.getDescription());
        existingTodo.setCompleted(todoDetails.isCompleted());
        
        return todoRepository.save(existingTodo);
    }

    public void deleteTodo(Long id) {
        log.info("Deleting todo with id: {}", id);
        todoRepository.deleteById(id);
    }
}
