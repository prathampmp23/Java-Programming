package com.cts.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.spring.Exception.CommentNotFoundException;
import com.cts.spring.dao.CommentsDao;
import com.cts.spring.model.Comments;

@Service
public class CommentsServiceImp implements CommnetsService {
	
	@Autowired
	CommentsDao dao;

	@Override
	public List<Comments> getAllComments() {
		return dao.findAll();
	}

	@Override
	public Comments addComment(Comments comment) {
		return dao.save(comment);
	}

	@Override
	public Comments getCommentById(int cid) {
		return dao.findById(cid).orElseThrow(() -> new CommentNotFoundException(cid)); // exception is called here
		// it pass to controller then -> it goes to either ExceptionHandler or RestControllerAdvice
	}

}
