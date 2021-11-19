package kz.maratbekovaidar.forum.repository;

import kz.maratbekovaidar.forum.model.Post;
import kz.maratbekovaidar.forum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByTitle(String title);
    void deleteById(Long id);
    Post getById(Long id);
    Collection<Post> findAllByOwner(User user);
}
