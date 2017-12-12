package pl.jerckov.cdc.ui.services;

class UserRequest {

    private final String name;

    UserRequest(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
