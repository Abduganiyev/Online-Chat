package Services.implement;

import Services.DemonstrationService;
import model.User;
import realization.ChatDemo;

import java.util.Scanner;

public class DemonstrationServiceImp implements DemonstrationService {
    @Override
    public void justUserMenu(User user) {

        Scanner scanner = new Scanner(System.in);

        User currentUser = ChatDemo.currentUser;

        System.out.printf("==========Welcome to %s our Online Chat==========\n",currentUser.getUsername());
        System.out.println("1. Send message");
        String choiceStr = scanner.next();
        int choice = -1;

        for (char c : choiceStr.toCharArray()) {
            if (Character.isDigit(c)) {
                choice = Integer.parseInt(String.valueOf(c));
                break;
            }
        }


    }

    @Override
    public void adminMenu(User user) {

    }
}
