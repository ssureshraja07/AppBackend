package Truckmate.com.App.repository;

import Truckmate.com.App.entity.Post;
import Truckmate.com.App.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository
        extends JpaRepository<Post, Long> {

    List<Post>
    findByUser(User user);
}