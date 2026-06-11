package Truckmate.com.App.service;

import java.util.List;

import Truckmate.com.App.dto.request.CreatePostRequestDTO;

import Truckmate.com.App.dto.response.ApiResponseDTO;
import Truckmate.com.App.dto.response.PostResponseDTO;

public interface PostService {

    ApiResponseDTO createPost(
            CreatePostRequestDTO request
    );

    List<PostResponseDTO> getAllPosts();

    ApiResponseDTO deletePost(
            Long postId
    );
}