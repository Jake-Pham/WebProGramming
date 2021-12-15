package KDA.dao;

import java.util.List;

import KDA.model.ShipModel;

public interface ShipDao {
	List<ShipModel> listAllCity();

	ShipModel getCityByID(String id);
}
