package io.github.uazw.dddtraining.register;

public class Link {

    private final String email;
    private final String identifer;
    private long createdTimeStamp;

    public Link(String email, String linkIdentifer) {
        this.email = email;
        this.identifer = linkIdentifer;
        this.createdTimeStamp = System.currentTimeMillis();
    }

    public String getEmail() {
        return email;
    }
}
