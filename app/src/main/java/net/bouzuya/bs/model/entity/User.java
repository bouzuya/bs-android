package net.bouzuya.bs.model.entity;

public final class User {
    private String id;

    private User(String id) {
        if (id == null) throw new IllegalArgumentException();
        this.id = id;
    }

    public static User of(String id) {
        return new User(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return this.id.equals(user.id);
    }

    public String getId() {
        return this.id;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}
