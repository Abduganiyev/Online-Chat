package Services.implement;

import Services.GroupService;
import enums.MsgStatus;
import model.Group;
import model.Message;
import realization.ChatDemo;

import javax.swing.event.ListDataEvent;
import java.io.CharConversionException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class GroupServiceImp implements GroupService {
    static Scanner scanner;
    @Override
    public boolean send() {
        scanner = new Scanner(System.in);

        boolean exite = true;
        String choiceStr;

        while (exite) {
            viewGroups();

            System.out.println("0. Exit");
            System.out.print("Sent to the group: ");
            choiceStr = scanner.next();

            Group chooseGroup = null;
            if (!Objects.equals(choiceStr, "0")) {

                for (Group group : ChatDemo.groups) {
                    if (group != null) {
                        if (group.getTitle().equals(choiceStr)) {
                            chooseGroup = group;
                            break;
                        }
                    }
                }

                if (chooseGroup != null) {
                    System.out.printf("To group: %s",chooseGroup.getTitle());
                    System.out.print("Message: ");
                    String messageToGroup = scanner.nextLine();

                    long nextId = ChatDemo.messages.size() + 1L;
                    Message message = new Message(nextId, messageToGroup, MsgStatus.DELIVERED);

                    for (Group group : ChatDemo.groups) {
                        if (group != null) {
                            if (group.getTitle().equals(choiceStr)) {
                                List<Message> messageList = group.getMessageList();
                                messageList.add(message);
                                group.setMessageList(messageList);
                                break;
                            }
                        }
                    }


                } else {
                    System.out.println("Group not found!\n");
                }
            } else {
                exite = false;
            }
        }
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public boolean edit() {
        return false;
    }
    private void viewGroups() {
        int index = 1;
        if (ChatDemo.currentUser.getGroups() != null) {
            for (Group group : ChatDemo.currentUser.getGroups()) {
                System.out.println(index++ + ". " + group.getTitle());
            }
        } else {
            System.out.println("Empty\n");
        }
    }

    private Group findById() {
        return null;
    }
}
