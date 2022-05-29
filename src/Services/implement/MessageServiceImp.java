package Services.implement;

import Services.MessageService;
import model.Message;

public class MessageServiceImp implements MessageService {
    @Override
    public boolean send(Message m) {
        return false;
    }

    @Override
    public boolean delete(Message m) {
        return false;
    }

    @Override
    public boolean edit(Message m) {
        return false;
    }
}
