package page.sample;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.CompoundPropertyModel;

import page.sample.administratorpackage.AdministratorPage;
import page.sample.userpackage.PrivateOfficeUserPage;
import dao.impl.AdministratorDao;
import dao.impl.UserDao;
import entity.User;

public class AuthorizationPage extends WebPage {

	public AuthorizationPage() {
		super();
		final UserDao userDao = new UserDao(
				app.MyFirstWebApplication.DATA_XML_FOLDER);
		final AdministratorDao administratorDao = new AdministratorDao(
				app.MyFirstWebApplication.DATA_XML_FOLDER);
		final User user = new User();

		Form<User> form = new Form("form",
				new CompoundPropertyModel<User>(user));
		form.add(new TextField<String>("login"));
		form.add(new PasswordTextField("password"));

		form.add(new SubmitLink("enter") {

			@Override
			public void onSubmit() {

				if (userDao.get(user.getLogin()) == null) {
					setResponsePage(new AuthorizationPage());
				}

				else {
					
					setResponsePage(new PrivateOfficeUserPage(userDao.get(user.getLogin())));
				}

			}
		});

		form.add(new Link("registration") {

			@Override
			public void onClick() {
				setResponsePage(new RegistrationPage());
			}

		});

		form.add(new Link("admin") {
			@Override
			public void onClick() {

				setResponsePage(new AdministratorPage(administratorDao.get("admin")));
			}

		});

		add(form);

	}
}
