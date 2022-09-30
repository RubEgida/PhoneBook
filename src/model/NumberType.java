package model;

/**
 * Phone number types.
 * @author Ruben
 */
public enum NumberType {
    MOBILE("Mobile"),
    HOME("Home"),
    WORK("Work"),
    SCHOOL("School"),
    ;

    private final String numberType;
    NumberType(String numberType) {
        this.numberType = numberType;
    }
    public String getNumberType() {
        return numberType;
    }
}
