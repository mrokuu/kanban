package org.example.progress;

public enum Progress {

    DOTO(0, false),
    DOING(1, true),
    DONE(2, true);

    private final int value;
    private final boolean inProgress;

    Progress(int value, boolean inProgress) {
        this.value = value;
        this.inProgress = inProgress;
    }

    public int getValue() {
        return value;
    }

    public boolean getInProgress() {
        return inProgress;
    }
}
