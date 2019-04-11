package lesson12.app;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Arrays;


public class Server {
    private int port;

    Connection connection;
    public Server(int port){
        this.port = port;
    }

    public static void main(String[] args) {
        int port = 8090;
        Server messageServer = new Server(port);
        try {
            messageServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server started...");
            while (true){
                Socket socket = serverSocket.accept();
                connection = new Connection(socket);
                printMessage(connection.readMessage());
                String user = connection.getUser(connection.readMessage());
                writeToFile("src/lesson12/app/userList.txt", true, Charset.forName("UTF-8"), user);
                String command = connection.getCommand();
                switch (command){
                    case "list_user":
                        String userList = readByteArray("src/lesson12/app/userList.txt", Charset.forName("UTF-8"));
                        connection.sendMessage(new Message("список пользователей", userList));


                }


                connection.sendMessage(new Message("server", "сообщение получено"));
//                getMessage(socket);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    public static void writeToFile(String fileName,
                                   boolean append, Charset charset, String user)
            throws IOException {

        try (FileOutputStream outputStream =new FileOutputStream(fileName, append))
        {
            StringBuilder sb = new StringBuilder();
            sb.append(user).append("\n");
            byte[] bytes = sb.toString().getBytes(charset);
            outputStream.write(bytes);
        }
    }

    public static String readByteArray(String fileName, Charset charset) throws IOException{

        try (
                FileInputStream fileInputStream = new FileInputStream(fileName);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        )
        {


            byte[] buf = new byte[1024];

            int len;

            while ((len = fileInputStream.read(buf)) > 0) {
                System.out.println(Arrays.toString(buf));
                byteArrayOutputStream.write(buf, 0, len);
            }

            System.out.println(Arrays.toString(byteArrayOutputStream.toByteArray()));
            String userList = new String(byteArrayOutputStream.toByteArray(), charset);
            return userList;
        }

    }


//    private void getMessage(Socket socket) throws IOException, ClassNotFoundException {
//        try (ObjectInputStream objIn = new ObjectInputStream(socket.getInputStream())){
//            Object obj = objIn.readObject();
//            printMessage((Message) obj);
//        }
//    }

    private void printMessage(Message message){
        System.out.println("получено сообщение: " +
                message.getMessageText() + " от " + message.getSender());
    }




}
