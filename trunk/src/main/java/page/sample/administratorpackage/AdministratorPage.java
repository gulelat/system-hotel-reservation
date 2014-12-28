package page.sample.administratorpackage;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

import page.sample.AuthorizationPage;
import entity.Administrator;

public class AdministratorPage extends WebPage {

	public AdministratorPage(final Administrator administrator) {
		add(new Label("message", "Hello, " + administrator.getName() + " "
				+ administrator.getLastname()));
		
		add(new Link("showUsers")
		{

			@Override
			public void onClick() {
				setResponsePage(new ShowUsers(administrator));
				
			}
		});
		
		add(new Link("exit")
		{

			@Override
			public void onClick() {
				setResponsePage(new AuthorizationPage());
				
			}
			
		});
	}
}
