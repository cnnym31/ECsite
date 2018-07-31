package com.internousdev.withm.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.withm.dto.DestinationInfoDTO;
import com.internousdev.withm.util.DBConnector;

public class DestinationInfoDAO {

	/* 宛先情報取得(リスト) */
	public List<DestinationInfoDTO> destinationInfoList(String userId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<DestinationInfoDTO> destinationInfoDTOList = new ArrayList<DestinationInfoDTO>();

		String sql = "SELECT * FROM destination_info WHERE user_id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				DestinationInfoDTO destinationInfoDTO = new DestinationInfoDTO();
				destinationInfoDTO.setId(resultSet.getInt("id"));
				destinationInfoDTO.setUserId(resultSet.getString("user_id"));
				destinationInfoDTO.setFamilyName(resultSet.getString("family_name"));
				destinationInfoDTO.setFirstName(resultSet.getString("first_name"));
				destinationInfoDTO.setFamilyNameKana(resultSet.getString("family_name_kana"));
				destinationInfoDTO.setFirstNameKana(resultSet.getString("first_name_kana"));
				destinationInfoDTO.setUserAddress(resultSet.getString("user_address"));
				destinationInfoDTO.setTelNumber(resultSet.getString("tel_number"));
				destinationInfoDTO.setInsertDate(resultSet.getDate("insert_date"));
				destinationInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
				destinationInfoDTOList.add(destinationInfoDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}

		return destinationInfoDTOList;
	}

	/* 宛先情報 */
	public DestinationInfoDTO destinationInfo(int id) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		DestinationInfoDTO destinationInfoDTO = new DestinationInfoDTO();

		String sql = "SELECT * FROM destination_info WHERE id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				destinationInfoDTO.setId(resultSet.getInt("id"));
				destinationInfoDTO.setUserId(resultSet.getString("user_id"));
				destinationInfoDTO.setFamilyName(resultSet.getString("family_name"));
				destinationInfoDTO.setFirstName(resultSet.getString("first_name"));
				destinationInfoDTO.setFamilyNameKana(resultSet.getString("family_name_kana"));
				destinationInfoDTO.setFirstNameKana(resultSet.getString("first_name_kana"));
				destinationInfoDTO.setUserAddress(resultSet.getString("user_address"));
				destinationInfoDTO.setTelNumber(resultSet.getString("tel_number"));
				destinationInfoDTO.setInsertDate(resultSet.getDate("insert_date"));
				destinationInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}

		return destinationInfoDTO;
	}

	/* 追加 */
	public int insert(String userId, String password, String familyName, String firstName,
			String familyNameKana, String firstNameKana, String userAddress, String telNumber) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "INSERT INTO destination_info(user_id, password, family_name, first_name,"
				+ " family_name_kana, first_name_kana, user_address, tel_number, insert_date, admin)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, now(), 0)";

		int count = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, familyName);
			preparedStatement.setString(4, firstName);
			preparedStatement.setString(5, familyNameKana);
			preparedStatement.setString(6, firstNameKana);
			preparedStatement.setString(7, userAddress);
			preparedStatement.setString(8, telNumber);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}

		return count;
	}

}
