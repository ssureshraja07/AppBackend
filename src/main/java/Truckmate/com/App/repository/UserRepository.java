package Truckmate.com.App.repository;

import Truckmate.com.App.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository
        extends JpaRepository<User, Long> {

    Optional<User>
    findByUserMobile(
            String userMobile
    );
}