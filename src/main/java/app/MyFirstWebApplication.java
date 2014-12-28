package app;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

import page.MyFirstWebPage;

/**
 * @author Dmitry_Zhivushko
 * 
 */
public class MyFirstWebApplication extends WebApplication {

	public static final String DATA_XML_FOLDER = "appDataXmlFolder";

	/**
	 * Constructor
	 */
	public MyFirstWebApplication() {
	}

	@Override
	public Class<? extends Page> getHomePage() {
		return MyFirstWebPage.class;
	}

}
