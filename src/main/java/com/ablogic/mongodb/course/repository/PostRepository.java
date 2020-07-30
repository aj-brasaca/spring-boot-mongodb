package com.ablogic.mongodb.course.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ablogic.mongodb.course.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
