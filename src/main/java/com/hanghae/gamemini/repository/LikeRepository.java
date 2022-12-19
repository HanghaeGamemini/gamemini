package com.hanghae.gamemini.repository;

import com.hanghae.gamemini.model.Likes;
import com.hanghae.gamemini.model.Post;
import com.hanghae.gamemini.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Likes, Long> {
    Optional<Likes> findByUserIdAndPostId(Long userId, Long postId);

    List<Likes> findByUserId(Long userId);

    List<Likes> findByUsername(User user);

    boolean existsByUserAndPost(User user, Post post);


}
