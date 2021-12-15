package KDA.service.impl;

import KDA.dao.InformationDAO;
import KDA.dao.impl.InformationDAOImpl;
import KDA.model.InformationModel;
import KDA.service.InformationService;

public class InformationServiceImpl implements InformationService{
	InformationDAO infDao=new InformationDAOImpl();
	@Override
	public InformationModel getInformation() {
		return infDao.getInformation();
	}
	@Override
	public void insert(InformationModel information) {
		// TODO Auto-generated method stub
		infDao.insert(information);
	}

}
