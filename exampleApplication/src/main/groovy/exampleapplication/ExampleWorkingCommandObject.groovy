package exampleapplication

import grails.validation.Validateable

class ExampleWorkingCommandObject implements Validateable, Serializable {

    String bindableProperty
    String nonBindableProperty

    static constraints = {
        nonBindableProperty nullable: false, bindable: false
        bindableProperty nullable: false
    }
}
