package com.openclassroom.projet5.service.status;

import java.util.List;

import com.openclassroom.projet5.model.status.CommunityEmail;

public interface ICommunityEmailService {

	List<CommunityEmail> getCommunityEmail(String city);

}
