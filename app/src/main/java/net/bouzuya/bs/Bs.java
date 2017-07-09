package net.bouzuya.bs;

class Bs {
    private final String createdAt;
    private final String note;

    private Bs(String createdAt, String note) {
        this.createdAt = createdAt;
        this.note = note;
    }

    static Bs of(String createdAt, String note) {
        return new Bs(createdAt, note);
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getNote() {
        return note;
    }
}
