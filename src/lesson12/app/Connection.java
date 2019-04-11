package lesson12.app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

public class Connection implements AutoCloseable{
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        out = new ObjectOutputStream(this.socket.getOutputStream());
        in = new ObjectInputStream(this.socket.getInputStream());
    }

    public void sendMessage(Message message) throws IOException {
        out.writeObject(message);
        out.flush();
    }

    public Message readMessage() throws IOException, ClassNotFoundException {
        return (Message) in.readObject();
    }

    public String getUser(Message message)  {


        return message.getSender();
    }

    public String getCommand() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        in.readObject();
        Class<Message> someCls = Message.class;
        Method method = someCls.getDeclaredMethod("getMessageText");
        method.setAccessible(true);
        String command = (String) method.invoke(in);
        return command;
    }

    @Override
    public void close() throws Exception {
        // закрытие ресурсов
        out.close();
        in.close();
    }
}