package Truckmate.com.App.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import Truckmate.com.App.dto.request.CreatePostRequestDTO;

import Truckmate.com.App.dto.response.ApiResponseDTO;
import Truckmate.com.App.dto.response.PostResponseDTO;

import Truckmate.com.App.service.PostService;

@RestController
@RequestMapping("/api/posts")

@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/create")
    public ApiResponseDTO createPost(
            @RequestBody CreatePostRequestDTO request
    ) {

        return postService.createPost(request);
    }

    @GetMapping
    public List<PostResponseDTO> getPosts() {

        return postService.getAllPosts();
    }

    @DeleteMapping("/{id}")
    public ApiResponseDTO deletePost(
            @PathVariable Long id
    ) {

        return postService.deletePost(id);
    }
}