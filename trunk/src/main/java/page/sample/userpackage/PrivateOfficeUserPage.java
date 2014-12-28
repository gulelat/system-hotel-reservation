package page.sample.userpackage;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

import entity.User;
import page.sample.AuthorizationPage;

public class PrivateOfficeUserPage extends WebPage {

	public PrivateOfficeUserPage(final User user) {
		add(new Label("message", "Hello, " + user.getName() + " "
				+ user.getLastname()));

		add(new Link("addBid") {

			@Override
			public void onClick() {
				
				setResponsePage(new AddBidPage(user));
				
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
