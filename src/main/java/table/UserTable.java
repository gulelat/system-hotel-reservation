package table;

import java.util.ArrayList;
import java.util.List;

import com.epam.grsulab.webapi.table.AbstractTable;

import entity.User;

public class UserTable extends AbstractTable<User> {

	List<User> rows;
	
	@Override
	public List<User> getRows() {
		if(rows == null)
		{
			rows = new ArrayList<User>();
		}
		return rows;
	}

	@Override
	public void setRows(List<User> rows) {
		this.rows = rows;	
	}

}
