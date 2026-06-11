package Truckmate.com.App.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import Truckmate.com.App.dto.request.CreatePostRequestDTO;

import Truckmate.com.App.dto.response.ApiResponseDTO;
import Truckmate.com.App.dto.response.PostResponseDTO;

import Truckmate.com.App.entity.Post;
import Truckmate.com.App.entity.User;

import Truckmate.com.App.mapper.PostMapper;

import Truckmate.com.App.repository.PostRepository;
import Truckmate.com.App.repository.UserRepository;

import Truckmate.com.App.service.PostService;

@Service
@RequiredArgsConstructor

public class PostServiceImpl
        implements PostService {

    private final PostRepository postRepository;

    private final UserRepository userRepository;

    @Override
    public ApiResponseDTO createPost(
            CreatePostRequestDTO request
    ) {

        Optional<User> userOptional =
                userRepository.findByUserMobile(
                        request.getUserMobile()
                );

        if (userOptional.isEmpty()) {

            return new ApiResponseDTO(
                    false,
                    "User not found"
            );
        }

        Post post =
                PostMapper.toEntity(
                        request,
                        userOptional.get()
                );

        postRepository.save(post);

        return new ApiResponseDTO(
                true,
                "Post created successfully"
        );
    }

    @Override
    public List<PostResponseDTO>
    getAllPosts() {

        return postRepository
                .findAll()
                .stream()
                .map(PostMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ApiResponseDTO deletePost(
            Long postId
    ) {

        if (!postRepository.existsById(postId)) {

            return new ApiResponseDTO(
                    false,
                    "Post not found"
            );
        }

        postRepository.deleteById(postId);

        return new ApiResponseDTO(
                true,
                "Post deleted successfully"
        );
    }
}