package KDA.service;

import java.util.List;

import KDA.model.CommentModel;

public interface CommentService {
	void insert(CommentModel comment);
	List<CommentModel> getbyPid(String pid);
}
