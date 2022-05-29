package Services.implement;

import Services.DemonstrationService;
import Services.MessageService;
import model.Message;
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
        System.out.println("2. Inbox");
        System.out.println("0. Exite");

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
                MessageService messageService = new MessageServiceImp();
                boolean isSucces = messageService.send();
                if (isSucces)
                    System.out.println("Sent\n");
                else
                    System.out.println("Somthing went wrong!\n");
                break;
            case 2:
                inbox();
                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 0:
                currentUser.setSingedIn(false);
                break;
            default:

        }

    }

    @Override
    public void adminMenu(User user) {
        Scanner scanner = new Scanner(System.in);

        User currentUser = ChatDemo.currentUser;

        System.out.printf("==========Welcome to %s our Admin menu==========\n",currentUser.getUsername());
        System.out.println("1. View Users");
        System.out.println("0. Exite");

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

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 0:
                currentUser.setSingedIn(false);
                break;
            default:

        }
    }

    private void inbox() {

        User currentUser = ChatDemo.currentUser;

        int index = 1;
        for (Message message : ChatDemo.messages) {
            if (message.getRecipient() != null) {
                if (message.getRecipient().getUsername().equals(currentUser.getUsername()))
                    System.out.println(index++ + "\n" + message);
            }
        }
    }
}
