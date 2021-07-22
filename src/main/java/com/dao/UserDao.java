package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository("user")
public class UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int addUser() {

		return jdbcTemplate.update("insert into users(uname,uemail,upassword,uage)values(?,?,?,?)", "samir",
				"samir@gmail.com", "sam123", 20);

	}// dml

	// ddl resultExcetrator,RowMapper

	private final static class UserMapper implements RowMapper<UserBean> {

		int count = 0;

		@Override
		public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {

			System.out.println("count =" + count++);
			UserBean userBean = new UserBean();
			userBean.setuName(rs.getString("uname"));
			userBean.setuId(rs.getInt("uid"));

			return userBean;
		}

	}

	public List<UserBean> getUsers() {

		return jdbcTemplate.query("select * from users", new UserMapper());
	}

	public List<UserBean> fetchUsers() {

		return jdbcTemplate.query("select * from users", new ResultSetExtractor<List<UserBean>>() {

			List<UserBean> userList = new ArrayList<UserBean>();

			@Override
			public List<UserBean> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {

					UserBean userBean = new UserBean();
					userBean.setuId(rs.getInt(1));
					userBean.setuName(rs.getString(2));
					userList.add(userBean);

				}

				return userList;
			}

		});

	}

	public UserBean getUsersById(int uid) {

		return jdbcTemplate.queryForObject("select * from users where uid = " + uid + "", new UserMapper());
	}

}
