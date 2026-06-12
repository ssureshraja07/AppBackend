package Truckmate.com.App.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long id;

    @Column(
            unique = true,
            nullable = false
    )
    private String mobileNumber;

    private String name;

    private LocalDate dob;

    private String role;

    private String city;

    @Column(length = 500)
    private String profilePicture;
}