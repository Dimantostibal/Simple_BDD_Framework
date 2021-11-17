package enums;

public enum Category {
    ОРГТЕХНИКА("оргтехника");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}