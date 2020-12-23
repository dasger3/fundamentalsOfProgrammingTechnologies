import com.company.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.*;
import static org.mockito.Mockito.*;

import java.util.*;

import static org.mockito.Mockito.*;



public class ATUIT {
    ArrayList<Region> listOfRegion;

    ArrayList<City>listOfCity1;
    ArrayList<City>listOfCity2;

    @Before
    public void setUp () {

        listOfRegion = new ArrayList<>();

        listOfCity1 = new ArrayList<>();
        listOfCity2 = new ArrayList<>();

        listOfRegion.add(mock(Region.class));
        listOfRegion.add(mock(Region.class));

        for (int i = 0; i < 4; i++) {
            listOfCity1.add(mock(City.class));
            listOfCity2.add(mock(City.class));
        }

    }

    @Test
    public void getMostFrequentTitleNames_whenRegionIsValid_True() {
        //GIVEN
        when(listOfCity1.get(0).getPosition()).thenReturn("mayor");
        when(listOfCity1.get(0).getTitle()).thenReturn("Dnepr");

        when(listOfCity1.get(1).getPosition()).thenReturn("mayor");
        when(listOfCity1.get(1).getTitle()).thenReturn("Poltava");

        when(listOfCity1.get(2).getPosition()).thenReturn("governor");
        when(listOfCity1.get(2).getTitle()).thenReturn("Poltava");

        when(listOfCity1.get(3).getPosition()).thenReturn("mayor");
        when(listOfCity1.get(3).getTitle()).thenReturn("Poltava");


        when(listOfCity2.get(0).getPosition()).thenReturn("mayor");
        when(listOfCity2.get(0).getTitle()).thenReturn("Kyiv");

        when(listOfCity2.get(1).getPosition()).thenReturn("governor");
        when(listOfCity2.get(1).getTitle()).thenReturn("Lutsk");

        when(listOfCity2.get(2).getPosition()).thenReturn("governor");
        when(listOfCity2.get(2).getTitle()).thenReturn("Lutsk");

        when(listOfCity2.get(3).getPosition()).thenReturn("governor");
        when(listOfCity2.get(3).getTitle()).thenReturn("Lutsk");


        when(listOfRegion.get(0).getCity()).thenReturn(listOfCity1);
        when(listOfRegion.get(1).getCity()).thenReturn(listOfCity2);


        List<String> expected = Arrays.asList("Poltava", "Lutsk");

        //WHEN
        List<String> result = Region.getMostFrequentTitleNames(listOfRegion);

        //THEN
        Assert.assertEquals(expected,result);
        verify(listOfRegion.get(0), times(1)).getCity();
    }

    @Test
    public void getCityPopulationSum_whenVillageIsValid_True() {
        //GIVEN
        when(listOfCity1.get(0).getSquare()).thenReturn(2000.0);
        when(listOfCity1.get(0).getPopulation()).thenReturn(100);

        when(listOfCity1.get(1).getSquare()).thenReturn(15.0);
        when(listOfCity1.get(1).getPopulation()).thenReturn(200);

        when(listOfCity1.get(2).getSquare()).thenReturn(150.0);
        when(listOfCity1.get(2).getPopulation()).thenReturn(300);

        when(listOfCity1.get(3).getSquare()).thenReturn(15.0);
        when(listOfCity1.get(3).getPopulation()).thenReturn(400);


        int expected = 400;

        //WHEN
        int actual = Region.getCityPopulationSum(listOfCity1);

        //THEN
        Assert.assertEquals(expected,actual);
        verify(listOfRegion.get(1), times(0)).getPopulation();
    }
}
