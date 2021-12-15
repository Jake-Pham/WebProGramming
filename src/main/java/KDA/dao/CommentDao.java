package KDA.dao;

import java.util.List;

import KDA.model.CommentModel;

public interface CommentDao {
	void insert(CommentModel comment);
	List<CommentModel> getbyPid(String pid);
}
