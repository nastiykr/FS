package ru.cft;

import static ru.cft.utils.PiUtil.calculatePi;
import static ru.cft.utils.StringUtil.format;

public class Application {
    public static void main(String[] args) {
        if (args.length>0){
            int count = Integer.parseInt(args[0]);
            int numbers = Integer.parseInt(args[1]);
            double pi = calculatePi(count);
            String result = format(pi, numbers);

            System.out.println(result);
        }
        else System.out.println(calculatePi(111));
    }
}
