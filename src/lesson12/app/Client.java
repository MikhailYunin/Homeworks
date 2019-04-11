package lesson12.app;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Properties;
import java.util.Scanner;

public class Client {
    private SocketAddress address;
    private Scanner scanner;

    public Client(SocketAddress address) {
        this.address = address;
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        while (true){
            System.out.println("Введите сообщение");
            String messageText = scanner.nextLine();

            try {
                buildAndSend(name, messageText);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void buildAndSend(String name, String messageText) throws IOException {
        Message message = new Message(name, messageText);
        Socket socket = null;
        try {
            socket = new Socket();
            socket.connect(address);

            try (OutputStream out = socket.getOutputStream();
                 ObjectOutputStream objOut = new ObjectOutputStream(out);
            ){
                objOut.writeObject(message);
                objOut.flush();
            }
        }
        finally {
            socket.close();
        }
    }

    public static void main(String[] args) {
        try (InputStream inputStream =
                     Client.class
                             .getClassLoader()
                             .getResourceAsStream("config.properties")){

            Properties properties = new Properties();
            properties.load(inputStream);

            String server = properties.getProperty("server");//"127.0.0.1";
            int port = Integer.parseInt(properties.getProperty("port")); //8090;
            Client messageClient =
                    new Client(new InetSocketAddress(server, port));
            messageClient.start();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
