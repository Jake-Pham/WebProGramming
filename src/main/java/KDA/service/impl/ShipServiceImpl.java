package KDA.service.impl;

import java.util.List;

import KDA.dao.ShipDao;
import KDA.dao.impl.ShipDaoImpl;
import KDA.model.ShipModel;
import KDA.service.ShipService;



public class ShipServiceImpl implements ShipService{
	ShipDao shipDao=new ShipDaoImpl();
	@Override
	public List<ShipModel> listAllCity() {
		// TODO Auto-generated method stub
		return shipDao.listAllCity();
	}
	@Override
	public ShipModel getCityByID(String id) {
		// TODO Auto-generated method stub
		return shipDao.getCityByID(id);
	}
}
