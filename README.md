# Grails bindable bug example project

To replicate issue:

1. run `exampleApplication` 
1. When server starts up try the following endpoints:

    
    `http://localhost:8080/example/broken?bindableProperty=bar&nonBindableProperty=baz`

returns `foo bar baz`
    
    `http://localhost:8080/example/working?bindableProperty=bar&nonBindableProperty=baz`

    
returns `foo bar null`



