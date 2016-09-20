package com.training;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class StatesRowMapper implements RowMapper<IndianStates> {
	public IndianStates mapRow(ResultSet rs, int rowNum) throws SQLException {
		IndianStates indianStates = new IndianStates();
		indianStates.setId(rs.getInt("Id"));
		indianStates.setStatename(rs.getString("statename"));
		indianStates.setCmname(rs.getString("cmname"));
		indianStates.setPopulation(rs.getInt("population"));
		indianStates.setNumofrivers(rs.getInt("numofrivers"));
		return indianStates;
	}
}
