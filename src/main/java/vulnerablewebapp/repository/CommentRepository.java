package vulnerablewebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vulnerablewebapp.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}