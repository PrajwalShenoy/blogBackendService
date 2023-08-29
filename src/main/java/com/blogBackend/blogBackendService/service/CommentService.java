package com.blogBackend.blogBackendService.service;

import com.blogBackend.blogBackendService.payload.CommentDto;

import java.util.List;

public interface CommentService {

    public CommentDto createComment(long postId, CommentDto commentDto);

    public List<CommentDto> getCommentsByPostId(long postId);

    public CommentDto getCommentById(long postId, long commentId);

    public CommentDto updateComment(long postId, long commentId, CommentDto commentDto);

    public void deleteComment(long postId, long commentId);

}
