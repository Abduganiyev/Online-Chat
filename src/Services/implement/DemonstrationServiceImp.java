package Services.implement;

import Services.*;
import model.Message;
import model.User;
import realization.ChatDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DemonstrationServiceImp implements DemonstrationService {
    static Scanner scanner;

    @Override
    public void justUserMenu(User user) {

        scanner = new Scanner(System.in);

        JustUserService justUserService = new JustUserServiceImp();
        MessageService messageService = new MessageServiceImp();
        GroupService groupService = new GroupServiceImp();

        User currentUser = ChatDemo.currentUser;

        System.out.printf("==========Welcome to %s our Online Chat==========\n",currentUser.getUsername());
        System.out.println("1. Send message to somebody");
        System.out.println("2. Inbox");
        System.out.println("3. Outbox");
        System.out.println("4. Sent message to group");
        System.out.println("5. Create new group/Subscribe");
        System.out.println("0. Exit");

        String choiceStr = scanner.next();
        int choice = -1;

        System.out.println();

        for (char c : choiceStr.toCharArray()) {
            if (Character.isDigit(c)) {
                choice = Integer.parseInt(String.valueOf(c));
                break;
            }
        }

        switch (choice) {
            case 1:
                boolean isSuccess = messageService.send();
                if (isSuccess)
                    System.out.println("Sent\n");
                else
                    System.out.println("Something went wrong!\n");
                break;
            case 2:
                justUserService.inbox();
                break;
            case 3:
                justUserService.outbox();
                break;
            case 4:
                groupService.send();
                break;
            case 5:
                boolean isSuccesfuly = groupService.createNewGroup_Subscribe();
                if (isSuccesfuly) {
                    System.out.println("DONE\n");
                } else {
                    System.out.println("Somthing went wrong!\n");
                }
                break;
            case 0:
                currentUser.setSingedIn(false);
                break;
            default:

        }

    }

    @Override
    public void adminMenu(User user) {

        scanner = new Scanner(System.in);

        AdminService adminService = new AdminServiceImp();
        User currentUser = ChatDemo.currentUser;

        System.out.printf("==========Welcome to %s our Admin menu==========\n",currentUser.getUsername());
        System.out.println("1. View Users");
        System.out.println("2. Block Users");
        System.out.println("3. Activate Users");
        System.out.println("4. Change Password");
        System.out.println("0. Exit");

        String choiceStr = scanner.next();
        int choice = -1;

        System.out.println();

        for (char c : choiceStr.toCharArray()) {
            if (Character.isDigit(c)) {
                choice = Integer.parseInt(String.valueOf(c));
                break;
            }
        }

        switch (choice) {
            case 1:
                adminService.viewUsers();
                break;
            case 2:
                boolean blockUser = adminService.blockUser();
                if (blockUser) {
                    System.out.println("The user is blocked\n");
                }
                break;
            case 3:
                boolean activateUser = adminService.activateUser();
                if (activateUser)
                    System.out.println("The user is activated\n");
                break;
            case 4:
                adminService.deleteUser();
                break;
            case 5:
                boolean changePassword = adminService.changePassword();
                if (changePassword)
                    System.out.println("Password successfully was change!\n");
                break;
            case 0:
                currentUser.setSingedIn(false);
                break;
            default:

        }
    }
}
