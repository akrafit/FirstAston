import customAarrayList.CustomArrayList;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Comparator;

public class CustomArrayListTest extends TestCase {

    CustomArrayList<String> list = new CustomArrayList<>();

    @Test
    public void testAdd() {
        list.add("test");
        assertEquals("test", list.get(0));
    }

    @Test
    public void testAddByIndex() {
        list.add("test");
        list.add("test1");
        list.add("test2");
        list.add(1, "test3");
        assertEquals("test3", list.get(1));
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddByIndexException(){
        list.add("test");
        list.add(3,"test4");
    }

    @Test
    public void testOnCycle() {
        CustomArrayList<Integer> integerList = new CustomArrayList<>();
        for (int i = 0; i < 10; i++) {
            integerList.add(i);
        }
        assertEquals(10, integerList.size());
    }

    @Test
    public void testDelete() {
        list.add("test");
        list.add("test2");
        list.delete(0);
        assertEquals("test2", list.get(0));
    }

    @Test
    public void testUpdate() {
        list.add("test");
        list.update(0, "test2");
        assertEquals("test2", list.get(0));
    }

    @Test
    public void testDeleteAll() {
        list.add("test");
        list.add("test2");
        list.deleteAll();
        assertEquals(0, list.size());
    }

    @Test
    public void testGet() {
        list.add("test");
        assertEquals("test", list.get(0));
    }

    @Test
    public void testSize() {
        list.add("test");
        assertEquals(1, list.size());
    }

    @Test
    public void testSort() {
        class Cat {
            private String name;
            private int age;

            public Cat(String name, int age) {
                this.name = name;
                this.age = age;
            }

            public int getAge() {
                return this.age;
            }

            public String getName() {
                return this.name;
            }
        }
        CustomArrayList<Cat> list = new CustomArrayList<>();
        list.add(new Cat("Tom", 3));
        list.add(new Cat("Барсик", 2));
        list.add(new Cat("Бегемот", 8));
        Comparator<Cat> comparator = Comparator.comparing(Cat::getAge);
        list.sort(comparator);
        assertEquals("Барсик", list.get(0).getName());
    }
}