package table;

import java.util.ArrayList;
import java.util.List;

import com.epam.grsulab.webapi.table.AbstractTable;

import entity.Administrator;

public class AdministratorTable extends AbstractTable<Administrator> {
	List<Administrator> rows;

	@Override
	public List<Administrator> getRows() {
		if (rows == null) {
			rows = new ArrayList<Administrator>();
		}
		return rows;
	}

	@Override
	public void setRows(List<Administrator> rows) {
		this.rows = rows;

	}

}