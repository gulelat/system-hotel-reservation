package table;

import java.util.ArrayList;
import java.util.List;

import com.epam.grsulab.webapi.table.AbstractTable;

import entity.DescriptionRoom;

public class DescriptionRoomTable extends AbstractTable<DescriptionRoom> {
	List<DescriptionRoom> rows;

	@Override
	public List<DescriptionRoom> getRows() {
		if (rows == null) {
			rows = new ArrayList<DescriptionRoom>();
		}
		return rows;
	}

	@Override
	public void setRows(List<DescriptionRoom> rows) {
		this.rows = rows;

	}

}