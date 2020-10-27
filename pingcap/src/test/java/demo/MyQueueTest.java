package demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2020-10-27 16:57
 * @Version 1.0
 */
public class MyQueueTest {
    private MyQueue<Integer> myQueue = new MyQueue<>();

    @Before
    public void initMyQueue(){
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
    }

    @Test
    public void myQueueFirstDeleteTest(){
        Assert.assertEquals(new Integer(1),myQueue.delete());
    }
    @Test
    public void myQueueFirstAddTest(){
        myQueue.add(4);
    }
    @Test
    public void myQueueDeleteAllTest(){
        Assert.assertEquals(new Integer(2),myQueue.delete());
        Assert.assertEquals((long)3,(long)myQueue.delete());
        Assert.assertEquals((long)4,(long)myQueue.delete());
        Assert.assertEquals(null,myQueue.delete());
    }
}
