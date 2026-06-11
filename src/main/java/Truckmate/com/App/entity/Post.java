package Truckmate.com.App.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "posts")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Post {

    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)

    private Long id;

    private String postImage;

    private String fromLocation;

    private String toLocation;

    private String travelDate;

    private String travelTime;

    private String description;

    @ManyToOne
    @JoinColumn(
            name = "user_id"
    )
    private User user;
}