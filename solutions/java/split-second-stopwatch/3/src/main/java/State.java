public enum State {
    READY("ready"),
    RUNNING("running"),
    STOPPED("stopped");

    private final String state;

    State(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
