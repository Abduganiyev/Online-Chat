package Services.implement;

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
            }
        }
    }
    @Override
    public void outbox() {

    }
}
