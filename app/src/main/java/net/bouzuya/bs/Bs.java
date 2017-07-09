package net.bouzuya.bs;

import org.threeten.bp.Instant;

class Bs {
    private final Instant createdAt;
    private final String content;

    private Bs(Instant createdAt, String content) {
        if (content == null) throw new IllegalArgumentException();
        if (createdAt == null) throw new IllegalArgumentException();
        this.content = content;
        this.createdAt = createdAt;
    }

    static Bs of(Instant createdAt, String note) {
        return new Bs(createdAt, note);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bs bs = (Bs) o;

        if (!createdAt.equals(bs.createdAt)) return false;
        return content.equals(bs.content);
    }

    public String getContent() {
        return content;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    @Override
    public int hashCode() {
        int result = createdAt.hashCode();
        result = 31 * result + content.hashCode();
        return result;
    }
}
