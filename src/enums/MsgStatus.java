package enums;

public enum MsgStatus {
    DELIVERED("Yuborildi"),
    CHECKED("Tekshirildi"),
    DAFT("Qoralama"),
    FAILED("Qaytarildi"),
    ACCEPTED("Qabulqilindi");

    private final String init;

    MsgStatus(String init) {
        this.init = init;
    }

    public String getInit() {
        return init;
    }
}
