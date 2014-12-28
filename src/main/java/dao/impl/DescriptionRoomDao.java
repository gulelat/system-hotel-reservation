package dao.impl;

import java.util.List;

import entity.Administrator;
import entity.DescriptionRoom;
import entity.User;
import table.AdministratorTable;
import table.BidTable;
import table.DescriptionRoomTable;
import table.UserTable;
import abstractelements.AbstractDao;

public class DescriptionRoomDao extends AbstractDao<DescriptionRoomTable, DescriptionRoom> {

	public DescriptionRoomDao(String rootFolderPath) {
		super(rootFolderPath);
	}

	@Override
	public void saveNew(DescriptionRoom entity) {

		final DescriptionRoomTable descriptionRoomTable = deserializeFromXml();

		descriptionRoomTable.getRows().add(entity);

		serializeToXml(descriptionRoomTable);
		
	}

	@Override
	public void update(DescriptionRoom entity) {
		final DescriptionRoomTable descriptionRoomTable = deserializeFromXml();
		for (final DescriptionRoom row : descriptionRoomTable.getRows()) {
			if (row.getName().equals(entity.getName())) {
				row.user = entity.user;
				row.setStatus(true);
				break;
			}
		}
		serializeToXml(descriptionRoomTable);
		
	}

	@Override
	public DescriptionRoom get(String name) {
		final DescriptionRoomTable descriptionRoomTable = deserializeFromXml();
		for (final DescriptionRoom row : descriptionRoomTable.getRows()) {
			if (row.getName().equals(name)) {
				return row;
			}
		}
		return null;
	}

	@Override
	public List<DescriptionRoom> getAll() {
		final DescriptionRoomTable descriptionRoomTable = deserializeFromXml();
		return descriptionRoomTable.getRows();
	}

	@Override
	public void delete(String login) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Class<DescriptionRoomTable> getTableClass() {
		// TODO Auto-generated method stub
		return DescriptionRoomTable.class;
	}

}
