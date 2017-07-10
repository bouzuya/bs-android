package net.bouzuya.bs.model.entity;

import org.threeten.bp.Instant;

public class Bs {
    private final Instant createdAt;
    private final String content;

    private Bs(Instant createdAt, String content) {
        if (content == null) throw new IllegalArgumentException();
        if (createdAt == null) throw new IllegalArgumentException();
        this.content = content;
        this.createdAt = createdAt;
    }

    public static Bs of(Instant createdAt, String note) {
        return new Bs(createdAt, note);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bs bs = (Bs) o;

        if (!this.createdAt.equals(bs.createdAt)) return false;
        return this.content.equals(bs.content);
    }

    public String getContent() {
        return this.content;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public int hashCode() {
        int result = this.createdAt.hashCode();
        result = 31 * result + this.content.hashCode();
        return result;
    }
}
