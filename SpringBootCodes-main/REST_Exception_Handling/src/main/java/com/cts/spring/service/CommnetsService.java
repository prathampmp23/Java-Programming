package com.cts.spring.service;

import java.util.List;

import com.cts.spring.model.Comments;

public interface CommnetsService {
	List<Comments> getAllComments();
	Comments addComment(Comments comment);
	Comments getCommentById(int cid);

}
