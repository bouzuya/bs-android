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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public String getContent() {
        return note;
    }
}
