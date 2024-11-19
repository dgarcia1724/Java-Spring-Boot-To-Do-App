package danny.todo_java_backend.repository;

import danny.todo_java_backend.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    // JpaRepository provides basic CRUD operations by default
    // You can add custom query methods here if needed
}
