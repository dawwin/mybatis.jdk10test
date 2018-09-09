package dwd.mybatisjdk10test.model;

public class User {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    /* package */ User setId(final Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(final String name) {
        this.name = name;
        return this;
    }
}
