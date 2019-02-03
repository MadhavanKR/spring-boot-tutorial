package mk.learning.employeeapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import mk.learning.employeeapp.model.SQLStatements;

@Component
public class DatabaseService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public boolean addEmployeeToDB(String employeeName, String employeeEmail) {
		try {
			jdbcTemplate.update(SQLStatements.addEmpSql, employeeName, employeeEmail);
			return true;
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteEmployeeFromDB(String empName) {
		try {
			int numRowsAffected = jdbcTemplate.update(SQLStatements.deleteEmpSql, empName);
			if (numRowsAffected > 0)
				return true;
			else
				return false;

		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public List<String> getEmployeeNames() {
		/*
		 * return value of queryForList - list of Maps. each member of list is a row.
		 * i.e list[0] is first row of result, list[1] is second row of result and so on
		 * the key in map is the column name. so to get the first row's name column
		 * value, you need to do list[1].get("name");
		 */
		List<Map<String, Object>> result;
		try {
			ArrayList<String> returnResult = new ArrayList<String>();
			result = jdbcTemplate.queryForList(SQLStatements.getEmpSql);
			if (result.size() == 0) {
				System.out.println("no results matching the condition");
				return null;
			} else {
				for (Map<String, Object> curRow : result) {
					String curEmpName = (String) curRow.get("name");
					returnResult.add(curEmpName);
				}
				return returnResult;
			}
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
