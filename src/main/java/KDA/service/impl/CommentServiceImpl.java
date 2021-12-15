package KDA.service.impl;

import java.util.List;

import KDA.dao.CommentDao;
import KDA.dao.impl.CommentDaoImpl;
import KDA.model.CommentModel;
import KDA.service.CommentService;

public class CommentServiceImpl implements CommentService{
	CommentDao commentDao = new CommentDaoImpl();
	@Override
	public void insert(CommentModel comment) {
		commentDao.insert(comment);
		
	}
	@Override
	public List<CommentModel> getbyPid(String pid) {
		// TODO Auto-generated method stub
		return commentDao.getbyPid(pid);
	}

}
