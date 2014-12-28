package page.sample.administratorpackage;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;

import page.sample.AuthorizationPage;
import dao.impl.DescriptionRoomDao;
import entity.Administrator;
import entity.DescriptionRoom;
import entity.User;

public class ChooseRoomPage extends WebPage {

	public ChooseRoomPage(final Administrator administrator, final User user)
	{
		final DescriptionRoomDao descriptionRoomDao = new DescriptionRoomDao(app.MyFirstWebApplication.DATA_XML_FOLDER);
		
		List<DescriptionRoom> rooms = new ArrayList<DescriptionRoom>();		
		for (final DescriptionRoom row : descriptionRoomDao.getAll()) {
			
			if(!row.isStatus())
			
			rooms.add(row);
		}
		
		add(new DataView<DescriptionRoom>("table-rows", new ListDataProvider<DescriptionRoom>(
				rooms)) {
			@Override
			protected void populateItem(final Item<DescriptionRoom> item) {
				final DescriptionRoom descriptionRoom = item.getModelObject();
				// add data for table cell in row
				item.add(new Label("name", descriptionRoom.getName()));
				item.add(new Label("place", descriptionRoom.getPlace()));
				item.add(new Label("classApartments", descriptionRoom.getClassApartments()));
				item.add(new Label("price", descriptionRoom.getPrice()));
				
				item.add(new Link("reservation") {
					@Override
					public void onClick() {
						DescriptionRoom descriptionRoom1 = descriptionRoomDao.get(descriptionRoom.getName());
						descriptionRoom1.user = user;
						descriptionRoomDao.update(descriptionRoom1);
						
						setResponsePage(new ShowBidsPage(administrator, user));
					}
					});
			}
		});
		
		add(new Link("showUsers") {

			@Override
			public void onClick() {
				setResponsePage(new ShowUsers(administrator));
			}

		});

		add(new Link("exit") {

			@Override
			public void onClick() {
				setResponsePage(new AuthorizationPage());

			}

		});
	}
}
