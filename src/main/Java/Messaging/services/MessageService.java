package Messaging.services;

public interface MessageService {
    void sendMessage(String message, String subject, String[] to);
}
