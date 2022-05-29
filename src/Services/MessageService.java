package Services;

import model.Message;

public interface MessageService {
    boolean send(Message m);
    boolean delete(Message m);
    boolean edit(Message m);
}
