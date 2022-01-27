package kz.maratbekovaidar.forum.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
@AllArgsConstructor
public class PostExport {
    private Long id;
    private String title;
    private String description;
    private String text;
    private String ownerUsername;
    private Collection<Comment> comments;
}
