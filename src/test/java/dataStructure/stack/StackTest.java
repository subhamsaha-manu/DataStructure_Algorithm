package java.dataStructure.stack;


import org.junit.Assert;
import org.junit.Test;




public class StackTest {

    @Test
    public void testNewStack(){
        StackAsLinkedList stack = new StackAsLinkedList();
        Assert.assertTrue(stack.isEmpty());

        stack.push(10);
        Assert.assertEquals(10,stack.peek());
        stack.push(20);
        stack.push(30);
        Assert.assertEquals(30,stack.pop());
        Assert.assertEquals(20,stack.pop());
        Assert.assertEquals(10,stack.pop());
        Assert.assertEquals(null,stack.pop());
    }
}
