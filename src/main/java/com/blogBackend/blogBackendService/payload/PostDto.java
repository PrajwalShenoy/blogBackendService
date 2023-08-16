package com.blogBackend.blogBackendService.payload;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class PostDto {
    private long id;
    private String title;
    private String description;
    private String content;
}
