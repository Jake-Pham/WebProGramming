package KDA.dao;

import KDA.model.InformationModel;

public interface InformationDAO {
	void insert(InformationModel information);
	InformationModel getInformation();
}
