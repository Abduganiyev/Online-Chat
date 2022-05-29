package enums;

public enum UserRole {
    JUST_CURRENT("Oddiy foydalanuvchi"),
    ADMIN("Boshqaruvchi");

    private final String init;

    UserRole(String init) {
        this.init = init;
    }

    public String getInit() {
        return init;
    }
}
