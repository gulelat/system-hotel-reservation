package dao.impl;

import java.util.List;

import entity.Bid;
import table.BidTable;
import table.UserTable;
import abstractelements.AbstractDao;

public class BidDao extends AbstractDao<BidTable, Bid> {

	public BidDao(String rootFolderPath) {
		super(rootFolderPath);
	}

	@Override
	public void saveNew(Bid entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Bid entity) {
		
	}

	@Override
	public Bid get(String login) {
		return null;
	}

	@Override
	public List<Bid> getAll() {
		final BidTable bidTable = deserializeFromXml();
		return bidTable.getRows();
	}

	@Override
	public void delete(String login) {
	}

	@Override
	protected Class<BidTable> getTableClass() {
		return BidTable.class;
	}

}
