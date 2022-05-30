package Services;

import model.Group;

public interface GroupService {
    boolean send();
    boolean delete();
    boolean edit();
    boolean createNewGroup_Subscribe();
    boolean createGroup();
    boolean subscribe();
    boolean sendSubscribe(Group g);
}
