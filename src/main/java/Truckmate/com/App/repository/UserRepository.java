package Truckmate.com.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import Truckmate.com.App.entity.User;

@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {

    Optional<User> findByMobileNumber(
            String mobileNumber
    );
}