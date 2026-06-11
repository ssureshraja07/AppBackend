package Truckmate.com.App.mapper;

import Truckmate.com.App.dto.request.CreatePostRequestDTO;
import Truckmate.com.App.dto.response.PostResponseDTO;

import Truckmate.com.App.entity.Post;
import Truckmate.com.App.entity.User;

public class PostMapper {

    private PostMapper() {}

    // CREATE POST
    public static Post toEntity(
            CreatePostRequestDTO dto,
            User user
    ) {

        Post post = new Post();

        post.setUser(user);

        post.setFromLocation(
                dto.getFromLocation()
        );

        post.setToLocation(
                dto.getToLocation()
        );

        post.setTravelDate(
                dto.getTravelDate()
        );

        post.setTravelTime(
                dto.getTravelTime()
        );

        post.setDescription(
                dto.getDescription()
        );

        post.setPostImage(
                dto.getPostImage()
        );

        return post;
    }

    // ENTITY -> RESPONSE DTO
    public static PostResponseDTO
    toResponseDTO(
            Post post
    ) {

        PostResponseDTO dto =
                new PostResponseDTO();

        dto.setId(
                post.getId()
        );

        dto.setFromLocation(
                post.getFromLocation()
        );

        dto.setToLocation(
                post.getToLocation()
        );

        dto.setTravelDate(
                post.getTravelDate()
        );

        dto.setTravelTime(
                post.getTravelTime()
        );

        dto.setDescription(
                post.getDescription()
        );

        dto.setPostImage(
                post.getPostImage()
        );

        return dto;
    }
}