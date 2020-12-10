import com.company.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionsToolsTest {

    private ArrayList<District>district1;
    private ArrayList<District>district2;
    private ArrayList<Village>village1;
    private ArrayList<City>city1;
    private ArrayList<City>city2;
    private Region region;
    private Region region1;
    private ArrayList<Region>listOfRegion;

    @Before
    public void setUp () {
        district1 = new ArrayList<>();

        district1.add(new District(TypeOfATU.DISTRICT,"Central",12.4,532,
                "Alex", "Voronin","manager"));

        district2 = new ArrayList<>();

        district2.add(new District(TypeOfATU.DISTRICT,"Central",12.4,532,
                "Alex", "Voronin","manager"));

        village1 = new ArrayList<>();

        village1.add(new Village(TypeOfATU.VILLAGE,"Verhovina",162.4,10,
                "Ivan", "Ivanov","head", "cattle"));
        village1.add(new Village(TypeOfATU.VILLAGE,"Viyki",20, 100,
                "Sidor", "Sidorov","head", "harvest"));
        village1.add(new Village(TypeOfATU.VILLAGE,"Sinelnikovo",20,50,
                "Sidor", "Sidorov","head", "cattle"));
        village1.add(new Village(TypeOfATU.VILLAGE,"Usichi",20,4,
                "Sidor", "Sidorov","head", "harvest"));


        city1 = new ArrayList<>();

        city1.add(new City(TypeOfATU.CITY,"Dnepr",2000,100,
                "Dmitriy", "Efremov","mayor", district1));
        city1.add(new City(TypeOfATU.CITY,"Poltava",15,200,
                "Bogdanov", "Bogdan","mayor", district2));
        city1.add(new City(TypeOfATU.CITY,"Poltava",150,300,
                "Bogdanov", "Bogdan","governor", district2));
        city1.add(new City(TypeOfATU.CITY,"Poltava",15,400,
                "Bogdanov", "Bogdan","mayor", district2));


        city2 = new ArrayList<>();

        city2.add(new City(TypeOfATU.CITY,"Dnepr",2000,115241,
                "Dmitriy", "Efremov","mayor", district1));
        city2.add(new City(TypeOfATU.CITY,"Lutsk",15,116524,
                "Bogdanov", "Bogdan","governor", district2));
        city2.add(new City(TypeOfATU.CITY,"Lutsk",15,116524,
                "Bogdanov", "Bogdan","governor", district2));
        city2.add(new City(TypeOfATU.CITY,"Lutsk",15,116524,
                "Bogdanov", "Bogdan","governor", district2));

        region = new Region(TypeOfATU.REGION,"Dnipropetrovska", 22.3,10000,
                "Borys","Filatov","governor", city1,city1.get(0),village1);
        region1 = new Region(TypeOfATU.REGION,"Dnipropetrovska", 22.3,10000,
                "Borys","Filatov","governor", city2,city2.get(0),village1);

        listOfRegion = new ArrayList<>();
        listOfRegion.add(region);
        listOfRegion.add(region1);
    }


    @Test
    public void getCityPopulationSum() {
        //GIVEN
        //only where square > 100
        //population square
        //100        2000
        //200        15
        //300        150
        //400        15
        int expected = 400;

        //WHEN
        int actual = Region.getCityPopulationSum(region.getCity());

        //THEN
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getAveragePopulaiton() {
        //GIVEN
        //10 100 50 4
        double expected = 41;

        //WHEN
        double actual = Region.getAveragePopulaiton(region.getVillage());

        //THEN
        Assert.assertEquals(actual, expected, 0);
    }

    @Test
    public void getMaxPopulation() {
        //GIVEN
        //100 200 300 400
        int expected = 400;

        //WHEN
        int actual = Region.getMaxPopulation(region.getCity());

        //THEN
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getGroupByMaterialAndLengthTest() {
        Map<Boolean, List<Village>> actual = Region.getGroupByOccupationAndPopulation(region.getVillage());
        Map<Boolean, List<Village>> expected = new HashMap<>();
        expected.put(Boolean.TRUE, Arrays.asList(village1.get(1)));
        expected.put(Boolean.FALSE, Arrays.asList(village1.get(0),village1.get(2),village1.get(3)));

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getMostFrequentTitleNames() {

        List<String> result = Region.getMostFrequentTitleNames(listOfRegion);
        List<String> expected = Arrays.asList("Poltava", "Lutsk");
        Assert.assertEquals(result, expected);
    }
}
