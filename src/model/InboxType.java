package model;

/**
 * Inbox types.
 * @author Ruben
 */
public enum InboxType {
    G_MAIL("Gmail"),
    I_CLOUD("iCloud"),
    OUT_LOOK("Outlook"),
    CUSTOM_MAIL("Custom Mail"),
    ;
    private final String inbox;
    InboxType(String inbox) {
        this.inbox = inbox;
    }
    public String getInbox() {
        return inbox;
    }
}
