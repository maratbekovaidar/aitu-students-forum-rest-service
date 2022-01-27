package kz.maratbekovaidar.forum.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private String ownerName;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
//    @JsonIgnoreProperties("post")
    private Post post;
}
