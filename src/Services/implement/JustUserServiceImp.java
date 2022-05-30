package Services.implement;

import Services.MessageService;
import enums.MsgStatus;
import model.Group;
import model.Message;
import model.User;
import realization.ChatDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JustUserServiceImp implements Services.JustUserService {
    static Scanner scanner;
    @Override
    public void inbox() {

        scanner = new Scanner(System.in);

        User currentUser = ChatDemo.currentUser;

        List<Message> messagesCurrenUser = new ArrayList<>();
        for (Message message : ChatDemo.messages) {
            if (message.getRecipient() != null) {
                if (message.getRecipient().getUsername().equals(currentUser.getUsername())) {
                    messagesCurrenUser.add(message);
                }
            }
        }

        boolean exit = true;
        while (exit) {
            int index = 1;
            for (Message message : messagesCurrenUser) {
                if (message.getRecipient() != null) {
                    if (message.getRecipient().getUsername().equals(currentUser.getUsername())) {
                        System.out.println(index++ + "\n" + message);
                    }
                }
            }

            if (messagesCurrenUser.size() == 0) {
                System.out.println("Empty");
                exit = false;
            }
            System.out.println("+ delete        - exit");
            System.out.print("Choice: ");
            String choiceStr = scanner.next();
            int choice = -1;

            for (char c : choiceStr.toCharArray()) {
                if (Character.isDigit(c)) {
                    choice = Integer.parseInt(String.valueOf(c));
                }
            }

            if (choice == -1) {
                switch (choiceStr) {
                    case "+":

                        break;
                    case "-":
                        exit=false;
                        break;
                }
            } else {
                Message choice_message = messagesCurrenUser.get(choice - 1);
                System.out.println(choice_message);

                MsgStatus msgStatus = choice_message.getStatus();
                switch (msgStatus) {
                    case REQUEST:
                        messagesCurrenUser.get(choice - 1).setStatus(MsgStatus.ACCEPTED);
                        String groupTitle = choice_message.getText().substring(1, ')');

                        for (Group group : ChatDemo.groups) {
                            if (group != null) {
                                if (group.getTitle().equalsIgnoreCase(groupTitle)) {
                                    group.addUser(choice_message.getSender());
                                    System.out.println("Request is accepted");
                                    break;
                                }
                            }
                        }
                        break;
                    case DELIVERED:
                        MessageService messageService = new MessageServiceImp();

                        messageService.readInbox();
                        break;
                }
            }
        }
    }
    @Override
    public void outbox() {

        scanner = new Scanner(System.in);

        User currentUser = ChatDemo.currentUser;

        List<Message> messagesCurrenUser = new ArrayList<>();
        for (Message message : ChatDemo.messages) {
            if (message != null) {
                if (message.getSender().getUsername().equals(currentUser.getUsername())) {
                    messagesCurrenUser.add(message);
                }
            }
        }

        System.out.println();

        boolean exit = true;
        while (exit) {
            int index = 1;
            for (Message message : messagesCurrenUser) {
                if (message != null) {
                    if (message.getSender().getUsername().equals(currentUser.getUsername())) {
                        System.out.println(index++ + "\n" + message);
                    }
                }
            }

            if (messagesCurrenUser.size() == 0) {
                System.out.println("Empty");
                break;
            }
            System.out.println("- exit");
            System.out.print("Choice: ");
            String choiceStr = scanner.next();
            int choice = -1;

            for (char c : choiceStr.toCharArray()) {
                if (Character.isDigit(c)) {
                    choice = Integer.parseInt(String.valueOf(c));
                }
            }

            if (choice == -1) {
                if ("-".equals(choiceStr)) {
                    exit = false;
                }
            } else {
                Message choice_message = messagesCurrenUser.get(choice - 1);
                System.out.println(choice_message);
            }
        }
    }

    @Override
    public void changePassword() {
        scanner = new Scanner(System.in);

        System.out.print("New Password: ");
        String pass = scanner.next();

        ChatDemo.currentUser.setPassword(pass);
        System.out.println("Password successfully was changed!\n");
    }
}
