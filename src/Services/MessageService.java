package Services;

import model.Message;

public interface MessageService {
    boolean send();
    boolean delete();
    boolean edit();
    boolean readInbox();
    boolean readOutbox();
}
