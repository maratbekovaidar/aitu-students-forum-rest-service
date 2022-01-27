package kz.maratbekovaidar.forum.controller;


import kz.maratbekovaidar.forum.model.Comment;
import kz.maratbekovaidar.forum.model.Post;
import kz.maratbekovaidar.forum.service.CommentService;
import kz.maratbekovaidar.forum.service.PostService;
import kz.maratbekovaidar.forum.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/comment")
@RequiredArgsConstructor
public class CommentController {
    private final PostService postService;
    private final UserService userService;
    private final CommentService commentService;

    @PostMapping("/create")
    public ResponseEntity<?> createComment(@RequestBody CommentParams commentParams, HttpServletRequest request) {
        String username = userService.getUsernameFromToken(request);
        commentService.addComment(new Comment(
                null,
                commentParams.text,
                username,
                postService.findById(commentParams.id)
        ));
        return ResponseEntity.ok().body("Comment added");
    }

    public static class CommentParams {
        public String text;
        public Long id;
    }
}
