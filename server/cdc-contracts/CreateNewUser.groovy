org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'POST'
        urlPath('/users')
        headers {
            header 'Content-Type': 'application/json'
        }
        body(
                name: $(client(regex('[a-zA-Z]+')), server('Jan')),
        )
    }

    response {
        status 201
        body(
                id: $(client('123'), server(regex('\\d+'))),
                name: $(client('Jan'), server(regex('[a-zA-Z]+')))
        )
        headers {
            header 'Content-Type': 'application/json'
        }
    }
}