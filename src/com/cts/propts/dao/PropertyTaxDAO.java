package com.cts.propts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cts.propts.exception.PropertyTaxPytException;
import com.cts.propts.model.PropertyTaxPyt;
import com.cts.propts.util.ApplicationUtil;

public class PropertyTaxDAO {

	public static Connection connection = null;

	public PropertyTaxDAO() {
		DBConnectionManager dbc;
		try {
			dbc = DBConnectionManager.getInstance();
			connection = dbc.getConnection();
		} catch (PropertyTaxPytException e) {
			System.out.println("getConnection() : SQLException -> " + e.getMessage());
		}
	}

	public boolean insertPropertyTaxPyt(ArrayList<PropertyTaxPyt> propertyTaxPyts) throws PropertyTaxPytException {
		boolean recordsAdded = false;
		int count = 0;

		// TYPE YOUR CODE HERE
		try {
			for (PropertyTaxPyt propertyTaxPyt : propertyTaxPyts) {
				PreparedStatement pstm = connection.prepareStatement("insert into propertyTax values(?,?,?,?,?,?,?,?);");
				pstm.setString(1, propertyTaxPyt.getPropertyId());
				pstm.setString(2, propertyTaxPyt.getOwnersName());
				pstm.setDouble(3, propertyTaxPyt.getAreaInSqFt());
				pstm.setString(4, propertyTaxPyt.getPropertyType());
				pstm.setDouble(5, propertyTaxPyt.getTaxAmount());
				pstm.setDate(6, ApplicationUtil.utilToSqlDateConverter(propertyTaxPyt.getDateOfPyt()));
				pstm.setDate(7, ApplicationUtil.utilToSqlDateConverter(propertyTaxPyt.getDueDate()));
				pstm.setDouble(8, propertyTaxPyt.getRevisedTaxAmt());

				count += pstm.executeUpdate();
			}
			if (count > 0) {
				System.out.println(count + " Row(s) added to database Successfully");
				recordsAdded = true;
			} else {
				System.out.println("No Record added to database as no one paid Property tax before due date");
			}
		} catch (SQLException e) {
			System.out.println("Error occured while processing insertPropertyTaxPyt Queary : " + e.getMessage());
		}
		return recordsAdded;
	}

	public ArrayList<PropertyTaxPyt> getPropertyTaxPyt() {

		ArrayList<PropertyTaxPyt> propertyTaxPytList = new ArrayList<>();

		try {
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("select * from propertyTax");
			while (rs.next()) {
				PropertyTaxPyt propertyTaxPyt = new PropertyTaxPyt();
				propertyTaxPyt.setPropertyId(rs.getString("propertyId"));
				propertyTaxPyt.setOwnersName(rs.getString("ownersName"));
				propertyTaxPyt.setAreaInSqFt(rs.getDouble("areaInSqFt"));
				propertyTaxPyt.setPropertyType(rs.getString("propertyType"));
				propertyTaxPyt.setTaxAmount(rs.getDouble("taxAmount"));
				propertyTaxPyt.setDateOfPyt(rs.getDate("dateofPyt"));
				propertyTaxPyt.setDueDate(rs.getDate("dueDate"));
				propertyTaxPyt.setRevisedTaxAmt(rs.getDouble("revisedTaxAmtInRs"));

				propertyTaxPytList.add(propertyTaxPyt);
			}
			return propertyTaxPytList;

		} catch (SQLException e) {
			System.out.println("Error occured while processing getPropertyTaxPyt Queary : " + e.getMessage());
		}
		return null;
	}

}
