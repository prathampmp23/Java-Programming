package com.cts.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.spring.model.Comments;

public interface CommentsDao extends JpaRepository<Comments, Integer> {

}
