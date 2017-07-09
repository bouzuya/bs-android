package net.bouzuya.bs;

import org.threeten.bp.Instant;

class Bs {
    private final Instant createdAt;
    private final String note;

    private Bs(Instant createdAt, String note) {
        this.createdAt = createdAt;
        this.note = note;
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
        return note.equals(bs.note);
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public String getContent() {
        return note;
    }

    @Override
    public int hashCode() {
        int result = createdAt.hashCode();
        result = 31 * result + note.hashCode();
        return result;
    }
}
