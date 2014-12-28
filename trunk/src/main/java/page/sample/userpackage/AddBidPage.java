package page.sample.userpackage;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.CompoundPropertyModel;

import dao.impl.UserDao;
import entity.Bid;
import entity.User;
import page.MyFirstWebPage;
import page.sample.AuthorizationPage;
import app.MyFirstWebApplication;

public class AddBidPage extends WebPage {

	public AddBidPage(final User user) {
		
		final Bid bid = new Bid();
		final UserDao userDao = new UserDao(app.MyFirstWebApplication.DATA_XML_FOLDER);
		
		Form<Bid> form = new Form<Bid>("form", new CompoundPropertyModel<Bid>(
				bid));

		form.add(new TextField<Integer>("place"));
		form.add(new TextField<Integer>("time"));
		
		form.add(new SubmitLink("class1") {

			@Override
			public void onSubmit() {
				bid.setClassApartments("class1");
			}

		});
		
		form.add(new SubmitLink("class2") {

			@Override
			public void onSubmit() {
				bid.setClassApartments("class2");
			}

		});
		
		form.add(new SubmitLink("class3") {
			

			@Override
			public void onSubmit() {
				bid.setClassApartments("class3");
			}

		});

		form.add(new SubmitLink("save") {

			@Override
			public void onSubmit() {
				user.getBids().add(bid);
				
				userDao.update(user);
				
				setResponsePage(new PrivateOfficeUserPage(user));
			}

		});

		form.add(new Link("cancel") {

			@Override
			public void onClick() {
				setResponsePage(new PrivateOfficeUserPage(user));
			}

		});

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

		add(form);
	}
}
