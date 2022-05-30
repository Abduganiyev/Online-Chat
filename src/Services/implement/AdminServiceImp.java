package Services.implement;

import Services.AdminService;
import enums.UserRole;
import enums.UserStatus;
import model.User;
import realization.ChatDemo;

import java.util.Scanner;

public class AdminServiceImp implements AdminService {

    static Scanner scanner;
    @Override
    public boolean viewUsers() {
        for (User user : ChatDemo.users) {
            if (user.getUserRole() == UserRole.JUST_CURRENT)
                System.out.println("User name: " + user.getUsername() + '\n' +
                                   "Document: " + user.getUserRole().getInit() + '\n' +
                                   "Date: " + user.getDateTime() + '\n');
        }
        return true;
    }

    @Override
    public boolean blockUser() {
        scanner = new Scanner(System.in);

        viewUsers();
        System.out.print("Enter user name: ");
        String username = scanner.next();

        User user = getUser(username);
        if (user != null)
            user.setUserStatus(UserStatus.BLOCKED);
        else
            System.out.println("user not found");
        return true;
    }
    @Override
    public boolean activateUser() {
        scanner = new Scanner(System.in);

        viewUsers();
        System.out.print("Enter user name: ");
        String username = scanner.next();

        User user = getUser(username);
        if (user != null)
            user.setUserStatus(UserStatus.ACTIVE);
        else
            System.out.println("user not found");
        return true;
    }

    @Override
    public boolean deleteUser() {
        scanner = new Scanner(System.in);

        viewUsers();
        System.out.print("Enter user name: ");
        String username = scanner.next();

        User user = getUser(username);
        if (user != null)
            ChatDemo.users.remove(user);
        else
            System.out.println("user not found");
        return true;
    }

    @Override
    public boolean changePassword() {
        scanner = new Scanner(System.in);

        System.out.print("New Password: ");
        String pass = scanner.next();

        ChatDemo.currentUser.setPassword(pass);
        return true;
    }
    private User getUser(String username) {
        for (User user : ChatDemo.users) {
            if (user.getUsername().equalsIgnoreCase(username))
                return user;

        }
        return null;
    }
}
