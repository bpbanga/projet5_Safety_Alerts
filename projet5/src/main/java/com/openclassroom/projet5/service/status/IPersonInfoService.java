package com.openclassroom.projet5.service.status;

import java.util.List;

import com.openclassroom.projet5.model.status.PersonInfo;

public interface IPersonInfoService {

	List<PersonInfo> getPersonInfo(String firstName, String lastName);

}
