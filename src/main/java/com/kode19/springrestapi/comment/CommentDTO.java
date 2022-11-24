package com.kode19.springrestapi.comment;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class CommentDTO {
    private long id;
    @NotEmpty(message = "name should not be null or empty")
    private String name;
    @NotEmpty(message = "email should not be null or empty")
    @Email
    private String email;
    @NotEmpty
    @Size(min = 10, message = "body shoud be minimum 10 character")
    private String body;
}
