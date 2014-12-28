package app;

import com.epam.grsulab.webapi.web.app.JettyServerRunner;

public class StartWebApp {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(final String[] args) throws Exception {
		JettyServerRunner.runServer(8080);
	}
}
