import com.company.ClassFile;
import com.company.ClassString;

import java.util.Scanner;


public class Application {

    public static void main(String[] args) {


        ClassString myObject1 = new ClassString();
        ClassFile myObject2 = new ClassFile();


        Scanner scanner = new Scanner(System.in);

        boolean runnig = true;

        while (runnig) {
            System.out.println("********************************************");
            System.out.println("Программа для работы со строками и файлами.");
            System.out.println("Работа со строками:");
            System.out.println("1 - Разворот строки. Работа со строкой как с последовательностью char символов");
            System.out.println("2 - Разворот строки. Работа со строкой при помощи StringBuilder");
            System.out.println("3 - Форматирование строки. Удаление лишних пробелов в начале и в конце строки");
            System.out.println("4 - Форматирование строки. Приведение всех символов строки к верхнему регистру");
            System.out.println("5 - Извлечение подстроки с указанием начального и конечного индекса");
            System.out.println(" ");
            System.out.println("Работа с файлами:");
            System.out.println("6 - Запись одной строки в файл");
            System.out.println("7 - Запись списка строк в файл");
            System.out.println("8 - Создание директории");
            System.out.println("9 - Удаление директории");
            System.out.println(" ");
            System.out.println("0 - Выход");
            System.out.println("********************************************\n");
            Integer inputInt = scanner.nextInt();

            switch (inputInt) {
                case 1:
                    myObject1.reverseStringChars();
                   break;
                case 2:
                    myObject1.reverseStringBuilder();
                    break;
                case 3:
                    myObject1.formatStringSpace();
                    break;
                case 4:
                    myObject1.formatStringUpperCase();
                    break;
                case 5:
                    myObject1.takeSubstring();
                    break;
               case 6:
                    myObject2.writeString();
                    break;
                case 7:
                    myObject2.writeStrings();
                    break;

                case 8:
                    myObject2.createDir();
                    break;
                case 9:
                    myObject2.removeDir();
                    break;
                case 0:
                    runnig = false;
                    break;
                default:
                    break;

            }
        }

    }
}