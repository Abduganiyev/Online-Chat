package Services;

import model.Group;

public interface GroupService {
    boolean send(Group g);
    boolean delete(Group g);
    boolean edit(Group g);
}
