package com.openclassroom.projet5.service.status;

import java.util.List;

import com.openclassroom.projet5.model.status.PhoneAlert;

public interface IPhoneAlertService {

	List<PhoneAlert> getPhoneAlert(int stationNumber);

}
