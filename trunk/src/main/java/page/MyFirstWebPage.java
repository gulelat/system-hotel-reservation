package page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

import dao.impl.DescriptionRoomDao;
import entity.DescriptionRoom;
import page.sample.AuthorizationPage;

public class MyFirstWebPage extends WebPage {

	public MyFirstWebPage(){
		super();
		add(new Link("goToOnlineShop") {
			@Override
			public void onClick() {
				
				setResponsePage(new AuthorizationPage());
			}
		});
	}
}
