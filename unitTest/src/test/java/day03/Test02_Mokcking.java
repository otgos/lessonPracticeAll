package day03;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class Test02_Mokcking {

    //we are testing if any class is mocked or not

    @Test
    void testMocking(){
        T02_Mocking dummyObj = Mockito.mock(T02_Mocking.class); //fake obj

        //these methods are mock obj, not real
        dummyObj.addStudent("Tom");
        dummyObj.deleteStudent("Mehmet");
        dummyObj.updateStudent("Jumu");

        //let us verify if method is called?
        verify(dummyObj).addStudent("Tom");
        verify(dummyObj).deleteStudent("Mehmet");
        verify(dummyObj).updateStudent("Jumu");


    }
    //test how many times these methods are called
    @Test
    void testHowManyTimesCalled(){
        T02_Mocking dummyObj2 = Mockito.mock(T02_Mocking.class);
        dummyObj2.addStudent("Mustafa");
        dummyObj2.addStudent("Mustafa");
        dummyObj2.addStudent("Vusani");

        verify(dummyObj2, times(2)).addStudent("Mustafa");

        //verify if method is not called with the different argument
        verify(dummyObj2, times(0)).addStudent("Ali");

        //any method which is not called
        verify(dummyObj2, never()).deleteStudent(anyString());

        //verify if method is called at least 2 times
        //** we may want to know that if the method should be called 2ice at least
        verify(dummyObj2, atLeast(2)).addStudent("Mustafa");
    }

    // verify the execution order of the methods
    //** we could have used
    @Test
    void testControlOrderOfMethods(){
        //** we could have used BeforeAll for this.....
        T02_Mocking dummyObj3 = Mockito.mock(T02_Mocking.class);
        dummyObj3.addStudent("Ali");
        dummyObj3.addStudent("Veli");
        dummyObj3.deleteStudent("Veli");

        InOrder inOrder = inOrder(dummyObj3);
        inOrder.verify(dummyObj3).addStudent("Ali");
        inOrder.verify(dummyObj3).addStudent("Veli");
        inOrder.verify(dummyObj3).deleteStudent("Ali");

        //change the order or  argument

    }
}
