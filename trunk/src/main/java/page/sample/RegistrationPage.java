package page.sample;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.CompoundPropertyModel;

import dao.impl.UserDao;
import entity.User;

public class RegistrationPage extends WebPage {
	UserDao userDao;
	TextField<String> login;
	TextField<String> password;
	TextField<String> name;
	TextField<String> lastname;
	User user = new User();

	public RegistrationPage() {

		userDao = new UserDao(app.MyFirstWebApplication.DATA_XML_FOLDER);

		login = new TextField<String>("login");
		password = new TextField<String>("password");
		name = new TextField<String>("name");
		lastname = new TextField<String>("lastname");

		user = new User();

		Form<User> form = new Form("form",
				new CompoundPropertyModel<User>(user));
		form.add(login);
		form.add(password);
		form.add(name);
		form.add(lastname);

		form.add(new SubmitLink("save") {

			@Override
			public void onSubmit() {
				super.onSubmit();
				if (user.getLogin() != null
						&& user.getPassword() != null
						&& user.getName() != null
						&& user.getLastname() != null) {
					userDao.saveNew(user);
					setResponsePage(new AuthorizationPage());
				}
			}
		});

		form.add(new Link("cancel") {

			@Override
			public void onClick() {
				setResponsePage(new AuthorizationPage());
			}

		});
		add(form);
	}
}
