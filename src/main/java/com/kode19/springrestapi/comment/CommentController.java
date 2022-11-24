package com.kode19.springrestapi.comment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/post")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("{postId}/comment")
    public ResponseEntity<CommentDTO> createComment(
            @PathVariable("postId") long postId,
            @Valid @RequestBody CommentDTO commentDTO) {

        return new ResponseEntity<>(commentService.createComment(postId, commentDTO), HttpStatus.CREATED);
    }

    @GetMapping("{postId}/comment")
    public ResponseEntity<List<CommentDTO>> getCommentByPostId(@PathVariable("postId") long id) {
        return new ResponseEntity<>(commentService.getCommentByPostId(id), HttpStatus.OK);
    }

    @GetMapping("{postId}/comment/{id}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable("postId") long postId, @PathVariable("id") long commentId) {
        return new ResponseEntity<>(commentService.getCommentById(postId, commentId), HttpStatus.OK);
    }

    @PutMapping("{postId}/comment/{id}")
    public ResponseEntity<CommentDTO> updateComment(
            @PathVariable("postId") long postId,
            @PathVariable("id") long commentId,
            @Valid @RequestBody CommentDTO commentDTO) {
        return new ResponseEntity<>(commentService.updateComment(postId, commentId, commentDTO), HttpStatus.OK);
    }

    @DeleteMapping("{postId}/comment/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteComment(@PathVariable("postId") long postId, @PathVariable("id") long commentId) {
        commentService.deleteComment(postId, commentId);
    }
}