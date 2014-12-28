package table;

import java.util.ArrayList;
import java.util.List;

import com.epam.grsulab.webapi.table.AbstractTable;

import entity.Bid;

public class BidTable extends AbstractTable<Bid> {
	List<Bid> rows;

	@Override
	public List<Bid> getRows() {
		if (rows == null) {
			rows = new ArrayList<Bid>();
		}
		return rows;
	}

	@Override
	public void setRows(List<Bid> rows) {
		this.rows = rows;

	}

}