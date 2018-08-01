package com.internousdev.withm.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.withm.dao.DestinationInfoDAO;
import com.internousdev.withm.dto.DestinationInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationCompleteAction extends ActionSupport implements SessionAware {

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String userAddress;
	private String telNumber;
	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;
		String userId = String.valueOf(session.get("loginId"));

		DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
		int count = destinationInfoDAO.insert(userId, familyName, firstName,
				familyNameKana, firstNameKana, userAddress, telNumber);

		if (count > 0) {
			List<DestinationInfoDTO> destinationInfoDTOList = new ArrayList<DestinationInfoDTO>();
			destinationInfoDTOList = destinationInfoDAO.destinationInfoList(userId);

			Iterator<DestinationInfoDTO> iterator = destinationInfoDTOList.iterator();
			if (!(iterator.hasNext())) {
				destinationInfoDTOList = null;
			}

			session.put("destinationInfoDTOList", destinationInfoDTOList);
			result = SUCCESS;
		}

		return result;
	}

	public String getFamilyName(){
		return familyName;
	}

	public void setFamilyName(String familyName){
		this.familyName = familyName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFamilyNameKana(){
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana){
		this.familyNameKana = familyNameKana;
	}

	public String getFirstNameKana(){
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana){
		this.firstNameKana = firstNameKana;
	}

	public String getUserAddress(){
		return userAddress;
	}

	public void setUserAddress(String userAddress){
		this.userAddress = userAddress;
	}

	public String getTelNumber(){
		return telNumber;
	}

	public void setTelNumber(String telNumber){
		this.telNumber = telNumber;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
