import java.util.*;

public class Main {

    public static void main(String[] args) {

        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();


        Random random = new Random();

        List<String> list = new ArrayList<String>();

        int k = 1;
        while(k<= 100) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 5; i++) {
                char c = chars[random.nextInt(chars.length)];
                sb.append(c);
            }

            String output = sb.toString();
            list.add(output);

            k++;
        }

        System.out.println("До сортировки: " + list);
        Collections.sort(list);
        System.out.println("Сортировка по возрастанию: " + list);

        Collections.reverse(list);
        System.out.println("Сортировка по убыванию: " + list);


    }
}