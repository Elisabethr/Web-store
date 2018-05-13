export class App {
	router: Router;

	configureRouter(config, router) {
		this.router = router;

		config.map([
		    { route: '', name: 'mainPage', moduleId: './mainPage', title: 'mainPage', nav: false },
			{ route: 'loggedin', name: 'loggedin', moduleId: './loggedin' , title: 'Log in', nav: false },
			{ route: 'logout', name: 'logout', moduleId: './logout' , title: 'Log out', nav: false, auth: true }
		]);
	}
}
