export class App {

  configureRouter(config, router) {
          this.router = router;
          config.title = 'My Aurelia app';
          config.map([
            { route: ['', 'home'],       name: 'home',       moduleId: 'home/index' },
            { route: 'addProduct',            name: 'addProduct',      moduleId: 'addProduct', nav: true },
            { route: 'logIn',            name: 'logIn',      moduleId: 'logIn', nav: true },
            { route: 'register',            name: 'register',      moduleId: 'register', nav: true },
          ]);
        }
}
