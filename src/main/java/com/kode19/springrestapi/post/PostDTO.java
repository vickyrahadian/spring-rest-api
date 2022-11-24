package com.kode19.springrestapi.post;

import com.kode19.springrestapi.comment.CommentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, message = "Post title should have min 2 char")
    private String title;

    @NotEmpty
    @Size(min = 10, message = "Post description should have min 10 char")
    private String description;

    @NotEmpty
    private String content;

    private Set<CommentDTO> comments;
}
