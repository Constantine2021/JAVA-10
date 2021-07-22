package by.bsu.lab10;

import java.util.Set;
import java.util.HashSet;
/*
С использованием множества выполнить попарное суммирование произвольного конечного ряда чисел по следующим правилам: на первом этапе
суммируются попарно рядом стоящие числа, на втором этапе суммируются
результаты первого этапа и т. д. до тех пор, пока не останется одно число
 */
public class App {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);

        System.out.println(set);

        System.out.println(new SetSum().sumAll(set));
    }
}
