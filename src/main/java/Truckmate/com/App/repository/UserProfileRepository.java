package Truckmate.com.App.repository;

import Truckmate.com.App.entity.User;
import Truckmate.com.App.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository
        extends JpaRepository<UserProfile, Long> {

    Optional<UserProfile>
    findByUser(User user);
}