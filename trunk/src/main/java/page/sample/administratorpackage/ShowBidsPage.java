package page.sample.administratorpackage;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;

import page.sample.AuthorizationPage;
import dao.impl.AdministratorDao;
import dao.impl.UserDao;
import entity.Administrator;
import entity.Bid;
import entity.User;

public class ShowBidsPage extends WebPage {

	public ShowBidsPage(final Administrator administrator, final User user)
	{
		final UserDao userDao = new UserDao(
				app.MyFirstWebApplication.DATA_XML_FOLDER);
		final AdministratorDao administratorDao = new AdministratorDao(
				app.MyFirstWebApplication.DATA_XML_FOLDER);

		add(new DataView<Bid>("table-rows", new ListDataProvider<Bid>(
				user.getBids())) {
			@Override
			protected void populateItem(final Item<Bid> item) {
				final Bid bid = item.getModelObject();
				// add data for table cell in row
				item.add(new Label("place", bid.getPlace()));
				item.add(new Label("apartments", bid.getClassApartments()));
				item.add(new Label("time", bid.getTime()));
				item.add(new Link("chooseRoom") {
					@Override
					public void onClick() {
						setResponsePage(new ChooseRoomPage(administrator, user));
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
