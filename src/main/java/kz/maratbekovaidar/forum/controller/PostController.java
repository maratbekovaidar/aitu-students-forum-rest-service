package kz.maratbekovaidar.forum.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import kz.maratbekovaidar.forum.model.Comment;
import kz.maratbekovaidar.forum.model.Post;
import kz.maratbekovaidar.forum.model.PostExport;
import kz.maratbekovaidar.forum.repository.PostRepository;
import kz.maratbekovaidar.forum.service.CommentService;
import kz.maratbekovaidar.forum.service.PostService;
import kz.maratbekovaidar.forum.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping(value = "/api/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    private final UserService userService;

    private final CommentService commentService;

    @Autowired
    private final PostRepository postRepository;

    @PostMapping("/create")
    ResponseEntity<PostExport> createPost(@RequestBody PostCreateParams params, HttpServletRequest request) {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        String token = authorizationHeader.substring("Bearer ".length());
        Algorithm algorithm = Algorithm.HMAC256("aidar".getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        String username = decodedJWT.getSubject();
        Post post = new Post();
        post.setText(params.text);
        post.setDescription(params.description);
        post.setTitle(params.title);
        post.setOwner(userService.getUser(username));

//        userService.getUser(username).setPosts(userService.getUser(username).getPosts().add(post));
        return ResponseEntity.ok().body(postService.create(post));
    }

    @GetMapping("/get")
    ResponseEntity<Post> getPost(@RequestParam("title") String title) {
        return ResponseEntity.ok().body(postService.findByTitle(title));
    }

    @GetMapping("/comments")
    ResponseEntity<List<Comment>> getComments(@RequestParam("id") Long id) {
        return ResponseEntity.ok().body(postService.getComments(id));
    }

    @PostMapping("/delete")
    ResponseEntity<?> deletePost(@RequestParam("title") String title) {
        postService.deletePost(title);
        return ResponseEntity.ok().body("Post deleted");
    }

    @GetMapping("/all")
    ResponseEntity<Collection<Post>> allPost() {
        return ResponseEntity.ok().body(postService.allPost());
    }

    public static class PostCreateParams{
        public String title;
        public String description;
        public String text;
    }

    @PostMapping("/edit")
    ResponseEntity<Post> editPost(@RequestParam("id") Long id,@RequestBody Post editPost) {
        Post post = postRepository.getById(id);
        post.setTitle(editPost.getTitle());
        post.setDescription(editPost.getDescription());
        post.setText(editPost.getText());
        postRepository.save(post);
        return ResponseEntity.ok().body(post);
    }
}
