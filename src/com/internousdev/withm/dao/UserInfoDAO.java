package com.internousdev.withm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.withm.dto.UserInfoDTO;
import com.internousdev.withm.util.DBConnector;

public class UserInfoDAO {

	/* ユーザー情報取得(リスト) */
	public List<UserInfoDTO> userInfoList(String userId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<UserInfoDTO> userInfoDTOList = new ArrayList<UserInfoDTO>();

		String sql = "SELECT * FROM user_info WHERE user_id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				UserInfoDTO userInfoDTO = new UserInfoDTO();
				userInfoDTO.setId(resultSet.getInt("id"));
				userInfoDTO.setUserId(resultSet.getString("user_id"));
				userInfoDTO.setPassword(resultSet.getString("password"));
				userInfoDTO.setFamilyName(resultSet.getString("family_name"));
				userInfoDTO.setFirstName(resultSet.getString("first_name"));
				userInfoDTO.setFamilyNameKana(resultSet.getString("family_name_kana"));
				userInfoDTO.setFirstNameKana(resultSet.getString("first_name_kana"));
				userInfoDTO.setSex(resultSet.getInt("sex"));
				userInfoDTO.setEmail(resultSet.getString("email"));
				userInfoDTO.setInsertDate(resultSet.getDate("insert_date"));
				userInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
				userInfoDTO.setAdmin(resultSet.getInt("admin"));
				userInfoDTOList.add(userInfoDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}

		return userInfoDTOList;
	}

	/* ユーザー情報取得(userIdで) */
	public UserInfoDTO select(String userId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		UserInfoDTO userInfoDTO = new UserInfoDTO();

		String sql = "SELECT * FROM user_info WHERE user_id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				userInfoDTO.setId(resultSet.getInt("id"));
				userInfoDTO.setUserId(resultSet.getString("user_id"));
				userInfoDTO.setPassword(resultSet.getString("password"));
				userInfoDTO.setFamilyName(resultSet.getString("family_name"));
				userInfoDTO.setFirstName(resultSet.getString("first_name"));
				userInfoDTO.setFamilyNameKana(resultSet.getString("family_name_kana"));
				userInfoDTO.setFirstNameKana(resultSet.getString("first_name_kana"));
				userInfoDTO.setSex(resultSet.getInt("sex"));
				userInfoDTO.setEmail(resultSet.getString("email"));
				userInfoDTO.setInsertDate(resultSet.getDate("insert_date"));
				userInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
				userInfoDTO.setAdmin(resultSet.getInt("admin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}

		return userInfoDTO;
	}

	/* ユーザー情報取得(userIdとpasswordで) */
	public UserInfoDTO select(String userId, String password) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		UserInfoDTO userInfoDTO = new UserInfoDTO();

		String sql = "SELECT * FROM user_info WHERE user_id=? AND password=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				userInfoDTO.setId(resultSet.getInt("id"));
				userInfoDTO.setUserId(resultSet.getString("user_id"));
				userInfoDTO.setPassword(resultSet.getString("password"));
				userInfoDTO.setFamilyName(resultSet.getString("family_name"));
				userInfoDTO.setFirstName(resultSet.getString("first_name"));
				userInfoDTO.setFamilyNameKana(resultSet.getString("family_name_kana"));
				userInfoDTO.setFirstNameKana(resultSet.getString("first_name_kana"));
				userInfoDTO.setSex(resultSet.getInt("sex"));
				userInfoDTO.setEmail(resultSet.getString("email"));
				userInfoDTO.setInsertDate(resultSet.getDate("insert_date"));
				userInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
				userInfoDTO.setAdmin(resultSet.getInt("admin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}

		return userInfoDTO;
	}

	/* 追加 */
	public int insert(String userId, String password, String familyName, String firstName,
			String familyNameKana, String firstNameKana, int sex, String email) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "INSERT INTO user_info(user_id, password, family_name, first_name,"
				+ " family_name_kana, first_name_kana, sex, email, insert_date, admin)"
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
			preparedStatement.setInt(7, sex);
			preparedStatement.setString(8, email);
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

	/* 更新 */
	public int update(String userId, String password, String familyName, String firstName,
			String familyNameKana, String firstNameKana, int sex, String email, int id) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "UPDATE user_info SET user_id=?, password=?,  family_name=?, first_name=?,"
				+ "family_name_kana=?, first_name_kana=?, sex=?, email=?, update_date=now()"
				+ " WHERE id=?";

		int count = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, familyName);
			preparedStatement.setString(4, firstName);
			preparedStatement.setString(5, familyNameKana);
			preparedStatement.setString(6, firstNameKana);
			preparedStatement.setInt(7, sex);
			preparedStatement.setString(8, email);
			preparedStatement.setInt(9, id);
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

	/* 削除 */
	public int delete(int id) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "DELETE FROM user_info WHERE id=?";

		int count = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
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
