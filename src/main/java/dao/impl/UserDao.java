package dao.impl;

import java.util.List;

import entity.User;
import table.UserTable;
import abstractelements.AbstractDao;

public class UserDao extends AbstractDao<UserTable, User>{

	public UserDao(String rootFolderPath) {
		super(rootFolderPath);
	}

	@Override
	public void saveNew(User newUser) {
		final UserTable userTable = deserializeFromXml();

		int count = 0;

		for (User row : userTable.getRows()) {
			if (row.getLogin().equals(newUser.getLogin()))
				count++;
		}

		if (count == 0) {
			userTable.getRows().add(newUser);
		}

		serializeToXml(userTable);
	}

	@Override
	public void update(User newUser) {
		
		final UserTable userTable = deserializeFromXml();
		for (User row : userTable.getRows()) {
			if (row.getLogin().equals(newUser.getLogin())) {
				row.setBids(newUser.getBids());
				break;
			}
		}
		serializeToXml(userTable);
	}

	@Override
	public User get(String login) {
		final UserTable userTable = deserializeFromXml();
		for (final User row : userTable.getRows())
		{
			if (row.getLogin().equals(login))
			{
				return row;
			}
		}
		
		return null;
	}

	@Override
	public List<User> getAll() {
		final UserTable userTable = deserializeFromXml();
		return userTable.getRows();
	}

	@Override
	public void delete(String login) {
		
	}

	@Override
	protected Class<UserTable> getTableClass() {
		return UserTable.class;
	}

}
