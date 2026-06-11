package Truckmate.com.App.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_profiles")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserProfile {

    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)

    private Long id;

    private String name;

    private Integer age;

    private String city;

    private String role;

    @Column(length = 500)
    private String bio;

    private String profilePicture;

    @OneToOne
    @JoinColumn(
            name = "user_id"
    )
    private User user;
}