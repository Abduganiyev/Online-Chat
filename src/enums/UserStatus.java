package enums;

public enum UserStatus {
    BLOCKED("Bu foydalanuvchi bloklanmagan"),
    ACTIVE("Bu foydalanuvchi bloklangan");

    private final String init;

    UserStatus(String init) {
        this.init = init;
    }

    public String getInit() {
        return init;
    }
}
