package Services.implement;

import Services.RegistrationService;
import enums.UserRole;
import enums.UserStatus;
import model.User;
import realization.ChatDemo;

import java.util.Scanner;

public class RegistrationServiceImp implements RegistrationService {
    static Scanner scanner;
    @Override
    public boolean signIn() {

        scanner = new Scanner(System.in);

        System.out.print("User Name: ");
        String username = scanner.next();

        scanner = new Scanner(System.in);
        System.out.print("Password: ");
        String password = scanner.next();

        for (User user : ChatDemo.users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                ChatDemo.currentUser = user;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean signUp() {

        scanner = new Scanner(System.in);

        System.out.print("User Name: ");
        String username = scanner.next();

        scanner = new Scanner(System.in);
        String password;
        System.out.print("Password: ");
        password = scanner.next();

        String confirm = "";
        int counter = 3;
        while (counter-- != 0 && !confirm.equals(password)) {
            System.out.print("Confirm: ");
            confirm = scanner.next();
        }

        for (UserRole role : UserRole.values()) {
            System.out.println(role.ordinal()+1 + ". " + role + " (" + role.getInit() + ")");
        }

        int choiceRole = 1;
        counter = 3;
        while (counter-- != 0) {
            try {
                System.out.print("Choice the role: ");
                int choose = scanner.nextInt();
                if (choose < UserRole.values().length) {
                    choiceRole = choose;
                    counter = 0;
                }
            } catch (Exception e) {
                System.out.println("Pease input number!\n");
            }
        }

        if (username.isBlank() || !confirm.equals(password))
            return false;

        Long nextId = ChatDemo.users.size()+1L;
        User user = new User(nextId, username, password, UserRole.values()[choiceRole], null, UserStatus.ACTIVE);
        return ChatDemo.users.add(user);
    }
}
