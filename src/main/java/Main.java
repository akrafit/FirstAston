import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        CustomArrayList<Cat> list = new CustomArrayList<>();
        list.add(new Cat("Барсик", (int) (Math.random() * 10)));
        list.add(new Cat("Бегемот", (int) (Math.random() * 10)));
        list.add(new Cat("Туман", (int) (Math.random() * 10)));

        list.forEach(cat -> System.out.println(cat.getAge()));
        for (Cat cat : list){
            System.out.println(cat.getName());

        }
        Comparator<Cat> comparator = Comparator.comparing(Cat::getAge);
        list.sort(comparator);
        list.forEach(cat -> System.out.println(cat.getAge()));
    }
}
