package exampleapplication

class ExampleController {

    def index(ExampleCommandObject example) {
        render("foo ${example.bindableProperty} ${example.nonBindableProperty}")
    }
}
