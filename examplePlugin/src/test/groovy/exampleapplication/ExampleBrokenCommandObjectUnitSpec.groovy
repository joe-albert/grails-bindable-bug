package exampleapplication

import grails.web.databinding.DataBinder
import spock.lang.Specification

class ExampleBrokenCommandObjectUnitSpec extends Specification implements DataBinder {

    def "test that bindable constraint #desc"() {
        given:
        ExampleBrokenCommandObject command = new ExampleBrokenCommandObject()
        command.bindableProperty = 'foo'
        command.nonBindableProperty = 'foo'

        when:
        bindData(command, bindingMap)

        then:
        bindable == (bindingMap."$field" == command."$field")

        where:
        desc                                                                           | bindingMap                   | bindable | field
        'being set prevents nonBindableProperty from being bound to the object'        | [nonBindableProperty: 'bar'] | false    | 'nonBindableProperty'
        'not being set on bindableProperty allows the field to be bound to the object' | [bindableProperty: 'bar']    | true     | 'bindableProperty'
    }

}
