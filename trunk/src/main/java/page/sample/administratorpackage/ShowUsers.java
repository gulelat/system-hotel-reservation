package page.sample.administratorpackage;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;

import dao.impl.AdministratorDao;
import dao.impl.UserDao;
import page.sample.AuthorizationPage;
import entity.Administrator;
import entity.User;

public class ShowUsers extends WebPage {

	public ShowUsers(final Administrator administrator) {

		final UserDao userDao = new UserDao(
				app.MyFirstWebApplication.DATA_XML_FOLDER);
		final AdministratorDao administratorDao = new AdministratorDao(
				app.MyFirstWebApplication.DATA_XML_FOLDER);

		add(new DataView<User>("table-rows", new ListDataProvider<User>(
				userDao.getAll())) {
			@Override
			protected void populateItem(final Item<User> item) {
				final User user = item.getModelObject();
				// add data for table cell in row
				item.add(new Label("login", user.getLogin()));
				item.add(new Label("password", user.getPassword()));
				item.add(new Label("name", user.getName()));
				item.add(new Label("lastname", user.getLastname()));

				item.add(new Link("showBids") {
					@Override
					public void onClick() {
						
						setResponsePage(new ShowBidsPage(administrator, userDao.get(user.getLogin())));
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
