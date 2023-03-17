package exampleapplication

class ExampleController {

    /**
     * Command objects are identical apart from their names and where they are defined.
     *
     * One is defined in a plugin (Broken), the other is defined in the main application where this controller is hosted (working)
     *
     * The takeaway is that bindable:false as a constraint is only respected if command is referenced in a controller
     *
     * @param brokenCommandObject
     * @return
     */


    /**
     * When http://localhost:8080/example/broken?bindableProperty=bar&nonBindableProperty=baz is accessed response is:
     * foo bar baz
     *
     * nonBindableProperty takes the value of `baz` which should be non-bindable and not brought into the command object
     *
     * @param brokenCommandObject
     * @return
     */
    def broken(ExampleBrokenCommandObject brokenCommandObject) {
        render("foo ${brokenCommandObject.bindableProperty} ${brokenCommandObject.nonBindableProperty}")
    }


    /**
     * When http://localhost:8080/example/working?bindableProperty=bar&nonBindableProperty=baz is accessed response is:
     * foo bar null
     *
     * nonBindableProperty rejects the value of `baz` since bindable: false was set, this is the correct behavior
     *
     * @param brokenCommandObject
     * @return
     */
    def working(ExampleWorkingCommandObject workingCommandObject) {
        render("foo ${workingCommandObject.bindableProperty} ${workingCommandObject.nonBindableProperty}")
    }
}
