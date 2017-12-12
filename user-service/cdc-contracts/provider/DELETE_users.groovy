import org.springframework.cloud.contract.spec.Contract

[

        Contract.make {
            request {
                name("delete a user")
                method 'DELETE'
                urlPath('/users/123')
                headers {
                    header 'Content-Type': 'application/json'
                }
            }

            response {
                status 204
                headers {
                    header 'Content-Type': 'application/json'
                }
            }
        }
]
