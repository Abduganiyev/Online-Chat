package realization;


import Services.DemonstrationService;
import Services.RegistrationService;
import Services.implement.DemonstrationServiceImp;
import Services.implement.RegistrationServiceImp;
import enums.UserRole;
import enums.UserStatus;
import model.*;

import java.util.*;

public class ChatDemo {
    public static Set<User> users;
    public static List<Message> messages;
    public static Set<Group> groups;
    public static User currentUser;

    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        users = new TreeSet<>();
        messages = new ArrayList<>();
        groups = new TreeSet<>();
        currentUser = null;

        users.add(new User(1L,"umar","asd123", UserRole.JUST_CURRENT,null,UserStatus.ACTIVE));

        int choice = -1;
        do {
            mainMenu();
            String choiceStr = scanner.next();
            for (char c : choiceStr.toLowerCase().toCharArray()) {
                if (Character.isDigit(c)) {
                    choice = Integer.parseInt(Character.toString(c));
                }
            }


            switch (choice) {
                case 1:
                    singIn();
                    break;
                case 2:
                    singUp();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Incorrect option\n");
            }
        } while (choice != 0);

    }

    private static void mainMenu() {
        System.out.println("1. Sign In");
        System.out.println("2. Sign Up");
        System.out.println("0. Exite");
    }

    private static void singUp() {
        RegistrationService registrationService = new RegistrationServiceImp();

        try {
            boolean isSucces = registrationService.signUp();
            if (isSucces)
                System.out.println("DONE\n");
            else
                System.out.println("Somthing went wrong!\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void singIn() {
        RegistrationService registrationService = new RegistrationServiceImp();
        DemonstrationService demonstrationService = new DemonstrationServiceImp();

        boolean isSucces = registrationService.signIn();
        if (isSucces) {
            currentUser.setSingedIn(isSucces);

            while (currentUser.isSingedIn() && currentUser.getUserStatus() == UserStatus.ACTIVE) {
                switch (currentUser.getUserRole()) {
                    case JUST_CURRENT:
                        demonstrationService.justUserMenu(currentUser);

                        break;
                    case ADMIN:
                        demonstrationService.adminMenu(currentUser);

                        break;
                }
            }
        }
        else
            System.out.println("User not found/Your account is blocked\n");
    }
}
