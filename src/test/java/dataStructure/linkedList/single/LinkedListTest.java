package test.java.dataStructure.linkedList.single;

import java.util.ArrayList;

import main.java.dataStructure.linkedList.single.LinkedList;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void testNewLinkedList(){
        LinkedList singly = new LinkedList();
        assertTrue(singly.isEmpty());       // linked list should be empty
        assertEquals(0, singly.length());   // length of linked list should be zero
        ArrayList<Object> listInt = new ArrayList<>();
        listInt.add(1);
        listInt.add(2);
        listInt.add(3.5);
        listInt.add("A");

        singly.createLinkedList(listInt);
        assertSame(1,singly.getFirst());
        assertFalse(singly.isEmpty());     // linked list should not be empty
        assertEquals(3, singly.length());  // length of linked list should be 1

    }
}
