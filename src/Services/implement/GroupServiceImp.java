package Services.implement;

import Services.GroupService;
import enums.MsgStatus;
import model.Group;
import model.Message;
import model.User;
import realization.ChatDemo;

import java.util.*;

public class GroupServiceImp implements GroupService {
    static Scanner scanner;
    @Override
    public boolean send() {
        scanner = new Scanner(System.in);

        boolean exite = true;
        String choiceStr;

        while (exite) {
            viewUserGroups();

            System.out.println("0. Exit");
            System.out.print("Sent to the group: ");
            choiceStr = scanner.nextLine();

            Group chooseGroup = null;
            if (!Objects.equals(choiceStr, "0")) {

                if (ChatDemo.currentUser.getGroups() != null) {
                    for (Group group : ChatDemo.currentUser.getGroups()) {
                        if (group != null) {
                            if (group.getTitle().equalsIgnoreCase(choiceStr)) {
                                chooseGroup = group;
                                break;
                            }
                        }
                    }
                }

                if (chooseGroup != null) {

                    System.out.println();
                    for (Message message : chooseGroup.getMessageList()) {
                        System.out.println(message.getSender().getUsername() + ". " + message.getText());
                    }
                    System.out.println();

                    System.out.printf("To group: %s",chooseGroup.getTitle());
                    System.out.print("\nMessage: ");
                    String messageToGroup = scanner.nextLine();

                    long nextId = ChatDemo.messages.size() + 1L;
                    Message message = new Message(nextId, messageToGroup,ChatDemo.currentUser,null, MsgStatus.DELIVERED);

                    for (Group group : ChatDemo.groups) {
                        if (group != null) {
                            if (group.getTitle().equalsIgnoreCase(choiceStr)) {
                                group.addMessage(message);
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

    @Override
    public boolean createNewGroup_Subscribe() {
        while (true) {
            scanner = new Scanner(System.in);

            System.out.println("1. Create new group");
            System.out.println("2. Subscribe to group");
            System.out.println("0. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    boolean group = createGroup();
                    if (group) {
                        System.out.println("Successfully created\n");
                    } else {
                        System.out.println("Something went wrong!\n");
                    }
                    break;
                case 2:
                    boolean subscribe = subscribe();
                    if (subscribe) {
                        System.out.println("Request sent wait report\n");
                    } else {
                        System.out.println("Something went wrong!\n");
                    }
                    break;
                default:
                    return true;
            }
        }
    }

    @Override
    public boolean createGroup() {
        scanner = new Scanner(System.in);

        System.out.print("Title: ");
        String title = scanner.nextLine();

        scanner = new Scanner(System.in);
        System.out.println("Description: ");
        String description = scanner.nextLine();

        Set<User> groupUsers = new HashSet<>();
        groupUsers.add(ChatDemo.currentUser);

        long nextId = ChatDemo.groups.size() + 1L;
        Group group = new Group(nextId, title, description, ChatDemo.currentUser, groupUsers);

        return ChatDemo.groups.add(group);
    }

    @Override
    public boolean subscribe() {
        scanner = new Scanner(System.in);

        viewGroups();
        System.out.print("Choice the group: ");
        String choiceStr = scanner.nextLine();
        int choice = -1;

        for (char c : choiceStr.toCharArray()) {
            if (Character.isDigit(c)) {
                choice = Integer.parseInt(choiceStr);
            } else break;
        }

        if (choice != -1) {
            Group groupchooce = null;

            if (ChatDemo.groups != null) {
                for (Group group : ChatDemo.groups) {
                    if (group != null) {
                        if (group.getTitle().equalsIgnoreCase(choiceStr)) {
                            groupchooce = group;
                            break;
                        }
                    }
                }
            }

            if (groupchooce != null) {

            } else {
                System.out.println("Group not found!\n");
                return false;
            }
        } else {
            Group groupchooce = null;

            if (ChatDemo.groups != null) {
                for (Group group : ChatDemo.groups) {
                    if (group != null) {
                        if (group.getTitle().equalsIgnoreCase(choiceStr)) {
                            groupchooce = group;
                            break;
                        }
                    }
                }
            }

            if (groupchooce != null) {
                return sendSubscribe(groupchooce);
            } else {
                System.out.println("Group not found!\n");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean sendSubscribe(Group g) {
        User groupAdmin = g.getGroupAdmin();
        long nextId = ChatDemo.messages.size() + 1L;

        String text = "(" + g.getTitle() + ")" +" shu guruhga qabul qiling";
        Message request = new Message(nextId, "Request",text,ChatDemo.currentUser,groupAdmin, MsgStatus.REQUEST);
        return ChatDemo.messages.add(request);
    }

    private void viewGroups() {
        int index = 1;
        if (ChatDemo.groups != null) {
            for (Group group : ChatDemo.groups) {
                System.out.println(index++ + ". " + group.getTitle());
            }
        } else {
            System.out.println("Empty\n");
        }
    }

    private void viewUserGroups() {
        int index = 1;
        if (ChatDemo.currentUser.getGroups() != null) {
            for (Group group : ChatDemo.currentUser.getGroups()) {
                if (group != null) {
                    System.out.println(index++ + ". " + group.getTitle());
                }
            }
        } else {
            System.out.println("Empty\n");
        }
    }
    private Group findById() {
        return null;
    }
}
