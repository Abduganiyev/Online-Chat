package Services;

public interface AdminService {
    boolean viewUsers();
    boolean blockUser();
    boolean activateUser();
    boolean deleteUser();
    boolean changePassword();
}
