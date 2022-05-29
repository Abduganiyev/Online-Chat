package Services.implement;

import Services.MessageService;
import enums.MsgStatus;
import model.Message;
import model.User;
import realization.ChatDemo;

import java.util.Scanner;

public class MessageServiceImp implements MessageService {
    @Override
    public boolean send() {

        Scanner scanner = new Scanner(System.in);

        User recipient = null;

        System.out.print("To: ");
        String recipientStr = scanner.next();

        for (User user : ChatDemo.users) {
            if (user.getUsername().equals(recipientStr)) {
                recipient = user;
                break;
            }
        }

        scanner = new Scanner(System.in);
        System.out.print("Subject: ");
        String subject = scanner.next();

        scanner = new Scanner(System.in);
        System.out.println("text:");
        String text = scanner.next();

        long nextId = ChatDemo.messages.size() + 1L;
        Message message = new Message(nextId, subject, text, ChatDemo.currentUser, recipient, MsgStatus.DELIVERED);

        return ChatDemo.messages.add(message);
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public boolean edit() {
        return false;
    }
}
