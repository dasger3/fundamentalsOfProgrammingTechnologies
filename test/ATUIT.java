import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.mockito.Mockito.*;

public class ATUIT {
    @Test
    public void with_unspecified_arguments() {
        List mockedList = mock(List.class);

//используем его
        mockedList.add("one");
        mockedList.clear();

//проверяем, были ли вызваны методы add с параметром "one" и clear
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }
}
