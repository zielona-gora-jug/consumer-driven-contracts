import org.springframework.cloud.contract.spec.Contract

[

        Contract.make {
            request {
                name("create a user")
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
                )
                headers {
                    header 'Content-Type': 'application/json'
                }
            }
        }
]
