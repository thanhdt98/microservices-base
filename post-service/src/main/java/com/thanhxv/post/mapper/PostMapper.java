package com.thanhxv.post.mapper;

import com.thanhxv.post.dto.response.PostResponse;
import com.thanhxv.post.entity.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostResponse toPostResponse(Post post);
}
