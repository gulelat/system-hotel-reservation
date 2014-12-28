package dao.impl;

import java.util.List;

import table.AdministratorTable;
import abstractelements.AbstractDao;
import entity.Administrator;

public class AdministratorDao extends
		AbstractDao<AdministratorTable, Administrator> {

	public AdministratorDao(String rootFolderPath) {
		super(rootFolderPath);
	}

	@Override
	public void saveNew(Administrator newAdministrator) {
		final AdministratorTable administratorTable = deserializeFromXml();

		int count = 0;

		for (Administrator row : administratorTable.getRows()) {
			if (row.getLogin().equals(newAdministrator.getLogin()))
				count++;
		}

		if (count == 0) {
			administratorTable.getRows().add(newAdministrator);
		}

		serializeToXml(administratorTable);
	}

	@Override
	public Administrator get(String login) {

		final AdministratorTable administratorTable = deserializeFromXml();
		for (final Administrator row : administratorTable.getRows()) {
			if (row.getLogin().equals(login)) {
				return row;
			}
		}
		return null;
	}

	@Override
	public void delete(String login) {

	}

	@Override
	public void update(Administrator newAdministrator) {
		}

	@Override
	public List<Administrator> getAll() {
		return null;
	}

	@Override
	protected Class<AdministratorTable> getTableClass() {
		return AdministratorTable.class;
	}

}
