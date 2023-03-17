package exampleapplication

import grails.validation.Validateable

class ExampleCommandObject implements Validateable, Serializable {

    String bindableProperty
    String nonBindableProperty

    static constraints = {
        nonBindableProperty null: false, bindable: false
        bindableProperty null: false
    }
}
