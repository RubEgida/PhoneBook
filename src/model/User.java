package model;

import java.util.HashMap;

/**
 * Contact type.
 * @author Ruben
 */
public class User {
    private String userFirstName;
    private String inbox;
    private HashMap<NumberType, Integer> numberType;

    /**
     * Constructor.
     * @param userFirstName - contact name
     * @param numberType - phone number type
     * @param inbox - email type
     */
    public User(String userFirstName, HashMap<NumberType, Integer> numberType, String inbox) {
        this.userFirstName = userFirstName;
        this.numberType = numberType;
        this.inbox = inbox;
    }

    /**
     * Getter for name.
     * @return contact name
     */
    public String getUserFirstName() {
        return userFirstName;
    }

    /**
     * Setter for name.
     * @param userFirstName - contact name
     */
    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    /**
     * Setter for inbox.
     * @param inbox - email
     */
    public void setInbox(String inbox) {
        this.inbox = inbox;
    }

    /**
     * Setter for HashMap list.
     * @param map - number type saving
     */
    public void setNumberType(HashMap<NumberType, Integer> map) {
        this.numberType = map;
    }

    /**
     * Override method.
     * @param o - member equals with o
     * @return equals true or no
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userFirstName.equals(user.userFirstName) &&
                inbox.equals(user.inbox);
    }

    /**
     * Override method.
     * @return toString look for user
     */
    @Override
    public String toString() {
        return userFirstName + "-> { "  +
                "Phone number: " + numberType +
                ", Inbox: " + inbox + " }";
    }

}
