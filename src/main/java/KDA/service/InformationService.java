package KDA.service;

import KDA.model.InformationModel;

public interface InformationService {
	void insert(InformationModel information);
	InformationModel getInformation();
}
