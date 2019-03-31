package lesson9;

import java.util.*;

enum MessagePriority {
    LOW, MEDIUM, HIGH, URGENT; // константы

    public static MessagePriority getPriority(int ord){
        for (MessagePriority mp: values()){
            if (ord == mp.ordinal()) {
                return mp;
            }
        }
        throw  new AssertionError("Wrong ordinal:" + ord);
    }
}


public class Message {


    private  int code;
    private MessagePriority priority;


    public static void main(String[] args) {
        List<Message> messages = MessageGenerator.generate(34);
        System.out.println(messages.toString());
        Message.countEachPriority(messages);
        Message.countEachCode(messages);
        Message.uniqueMessageCount(messages);
        Message.uniqueMessagesInOriginalOrder(messages);
        Message.removeEach(messages, MessagePriority.LOW);
        Message.removeOther(messages, MessagePriority.HIGH);
    }



    public Message(int code, MessagePriority priority) {
        this.code = code;
        this.priority = priority;
    }


    public int getCode() {
        return code;
    }

    public MessagePriority getPriority() {
        return priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return getCode() == message.getCode() &&
                getPriority() == message.getPriority();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getPriority());
    }

    @Override
    public String toString() {
        return "{" +priority +", "+ code + "}";
    }





    public static void countEachPriority(List<Message> messageList) {
        // Подсчитать количество сообщений для каждого приоритела
        // Ответ в консоль
        int countLow = 0, countHigh = 0, countMedium = 0, countUrgent = 0;
        for(Message message: messageList){
            if (message.priority == MessagePriority.LOW){
                countLow ++;
            }
            if (message.priority == MessagePriority.MEDIUM){
                countMedium ++;
            }
            if (message.priority == MessagePriority.HIGH){
                countHigh ++;
            }
            if (message.priority == MessagePriority.URGENT){
                countUrgent ++;
            }

        }
        System.out.println("Low - "+ countLow+", Medium - " +countMedium+", High - "+countHigh+", Urgent - "+countUrgent);

    }

    public static void countEachCode(List<Message> messageList) {
        // Подсчитать количество сообщений для каждого кода сообщения
        // Ответ в консоль
        int[] codeCount = new int[10];
        for (Message m: messageList){
            codeCount[m.getCode()]++;
        }
        for (int i = 0; i < codeCount.length; i++) {
            System.out.println(i + ": " + codeCount[i]);}


//        ArrayList<Message> messageArrayList = new ArrayList<Message>();
//        for (int i = 0; i<messageList.size(); i++){
//            messageArrayList.add(messageList.get(i));
//


//        HashSet<Integer> distinctCodeSet = new HashSet<Integer>();
//        HashMap<Integer, Integer> codeCount = new HashMap<Integer, Integer>();
//
//        for (int i = 0; i<messageList.size(); i++){
//            if (distinctCodeSet.add(messageList.get(i).code)) {
//                codeCount.putIfAbsent(messageList.get(i).code, 1);
//                System.out.println(codeCount.get(i));
//            }
//            //else codeCount.put(messageList.get(i).code, codeCount.get(i)+1);
//        System.out.println(codeCount.toString());
//        }


    }

    private static void uniqueMessageCount(List<Message> messageList) {
        // Подсчитать количество уникальных сообщений
        // Ответ в консоль
        Set<Message> uniqueMessage = new HashSet<>();
        for(Message message: messageList){
            uniqueMessage.add(message);
        }

        System.out.println("\nКоличество уникальных сообщений - "+uniqueMessage.size());
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList){
        // вернуть только неповторяющиеся сообщения и в том порядке, в котором они
        // встретились в первоначальном списке
        // Например, было
//        [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        // на выходе:
        // [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
       Set<Message> uniqueMessage = new LinkedHashSet<>();
       for(Message message: messageList){
           uniqueMessage.add(message);
       }
       messageList.clear();
       for (Message message: uniqueMessage){
           messageList.add(message);
       }
       System.out.println(messageList);

       return messageList;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority){
        // удалить из коллекции каждое сообщение с заданным приоритетом
        // вывод до удалеия и после удаления
        System.out.println("\nСписок сообщений до удаления с приоритетом " +priority+"\n"+messageList);
        for (int i =0; i<messageList.size(); i++){
            if (messageList.get(i).getPriority() == priority) {
                messageList.remove(i);
            }
        }
        System.out.println("Список сообщений после удаления с приоритетом " +priority+"\n"+messageList);

    }

    public static void removeOther(List<Message> messageList, MessagePriority priority){
        // удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        // вывод до удалеия и после удаления
        System.out.println("\nСписок сообщений полный\n"+messageList);
        for (int i =0; i<messageList.size(); i++){
            if (messageList.get(i).getPriority() != priority) {
                messageList.remove(i);
            }
        }
        System.out.println("Список сообщений с приоритетом " +priority+"\n"+messageList);

    }

}

class MessageGenerator {
    public static List<Message> generate (int num){
        if (num <= 0 ) {
            return Collections.emptyList();
        }

        Random random = new Random();
        List<Message> messages = new ArrayList<>(num);

        // values() - вернет массив констант
        int  typesCount = MessagePriority.values().length;
        for (int i = 0; i<num; i++){
            messages.add(
                    new Message(
                            random.nextInt(10),
                            MessagePriority.getPriority(random.nextInt(typesCount)))
            );
        }
        return messages;
    }
}