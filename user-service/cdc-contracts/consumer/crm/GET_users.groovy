import org.springframework.cloud.contract.spec.Contract

[

        Contract.make {
            request {
                name("get a user")
                method 'GET'
                urlPath('/users/123')
            }

            response {
                status 200
                body(
                        name: $(client('Kowalski'), server(regex('[a-zA-Z]+'))),
                )
                headers {
                    header 'Content-Type': 'application/json'
                }
            }
        },
        Contract.make {
            request {
                name("user not found")
                method 'GET'
                urlPath('/users/456')
            }

            response {
                status 404
            }
        }
]
