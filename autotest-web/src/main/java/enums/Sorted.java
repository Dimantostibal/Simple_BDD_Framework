package enums;

public enum Sorted {
    ДОРОЖЕ("Дороже");

    private final String value;

    Sorted(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}