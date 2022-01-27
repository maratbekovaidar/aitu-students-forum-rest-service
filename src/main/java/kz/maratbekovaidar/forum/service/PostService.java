package kz.maratbekovaidar.forum.service;

import kz.maratbekovaidar.forum.model.Comment;
import kz.maratbekovaidar.forum.model.Post;
import kz.maratbekovaidar.forum.model.PostExport;
import kz.maratbekovaidar.forum.repository.CommentRepository;
import kz.maratbekovaidar.forum.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public Post findByTitle(String title) {
        return postRepository.findByTitle(title);
    }

    public PostExport create(Post post) {
        postRepository.save(post);
        return new PostExport(
                post.getId(),
                post.getTitle(),
                post.getDescription(),
                post.getText(),
                post.getOwner().getUsername(),
                new ArrayList<>()
        );
    }

    public List<Comment> getComments(Long id) {
        return commentRepository.findAllByPost(postRepository.getById(id));
    }

    public List<Post> allPost() {
        return postRepository.findAll();
    }

    public void deletePost(String title) {
        postRepository.delete(findByTitle(title));
    }

    public Post findById(Long id) {
        return postRepository.getById(id);
    }



}
