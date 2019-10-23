package adp1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Run with gradle:
 * ./gradlew clean test
 */
public class DoubleLinkedListTest {

    public DoubleLinkedList makeList1() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        String[] strings = {"aa", "bb", "cc", "dd"};
        for (int i = 0; i < strings.length; i++) {
            list.addFirst(strings[i]);
        }
        return list;
    }

    public DoubleLinkedList makeList2() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        String[] strings = {"aa", "bb", "cc"};
        for (int i = 0; i < strings.length; i++) {
            list.addFirst(strings[i]);
        }
        return list;
    }

    @Test
    public void addTest() {
        DoubleLinkedList<String> list1 = makeList1();
        DoubleLinkedList<String> list2 = makeList2();
        list2.addFirst("dd");
        assertEquals(list2, list1);
    }

    @Test
    public void addAdTest() {
        DoubleLinkedList<String> list1 = makeList1();
        DoubleLinkedList<String> list2 = makeList2();
        list2.addAt("dd", 0);
        assertEquals(list2, list1);
    }

    @Test
    public void deleteFirstTest() throws EmptyListException {
        DoubleLinkedList<String> list1 = makeList1();
        DoubleLinkedList<String> list2 = makeList2();
        // Checking if size of list1 is 4
        assertEquals(4, list1.size());

        list1.deleteFirst();
        // Checking if size of list1 has decreased to 3
        assertEquals(3, list1.size());
        assertEquals(list1, list2);
    }

    @Test
    public void deleteAtTest() {
        DoubleLinkedList<String> list1 = makeList1();
        DoubleLinkedList<String> list2 = makeList2();

        // Checking if size of list1 is 4
        assertEquals(4, list1.size());
        // deleting first element
        list1.deleteAt(0);
        assertEquals(list1, list2);

        // Creating list3 which is the same than actual list1, except
        // that it has no element in position 1
        DoubleLinkedList<String> list3 = new DoubleLinkedList<>();
        list3.addFirst("aa");
        list3.addFirst("cc");

        list1.deleteAt(1);
        // Checking if size of list1 has decreased to 2
        assertEquals(2, list1.size());
        assertEquals(list3, list1);

        // Deleting element at the last position
        list1.deleteAt(1);

        // Creating list4 which is the same than actual list1, except
        // that it has no element in position 1
        DoubleLinkedList<String> list4 = new DoubleLinkedList<>();
        list4.addFirst("cc");
        assertEquals(list4, list1);
    }

    @Test
    public void deleteLastTest() throws EmptyListException {
        DoubleLinkedList<String> list1 = makeList1();
        // Creating list2 for comparing purposes
        DoubleLinkedList<String> list2 = new DoubleLinkedList<>();
        list2.addFirst("bb");
        list2.addFirst("cc");
        list2.addFirst("dd");
        list1.deleteLast();
        assertEquals(list2, list1);
    }

    

}
