package KDA.service;

import java.util.List;

import KDA.model.ShipModel;

public interface ShipService {
	List<ShipModel> listAllCity();
	ShipModel getCityByID(String id);
}
