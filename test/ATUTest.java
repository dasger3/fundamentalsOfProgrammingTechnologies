import com.company.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Date;


public class ATUTest {
    @Before

    @Test
    public void EqualsATU_IsCompareCorrect_True() {
        //GIVEN
        ArrayList<District> district1 = new ArrayList<>();
        district1.add(new District(TypeOfATU.DISTRICT,"Central",12.4,532,
                "Alex", "Voronin","manager"));
        district1.add(new District(TypeOfATU.DISTRICT,"Southside",2.4,123,
                "Vladimyr", "Doroh","manager"));
        ArrayList<District>district2 = new ArrayList<>();
        district2.add(new District(TypeOfATU.DISTRICT,"Central",12.4,532,"Alex", "Voronin","manager"));
        ArrayList<Village>village1 = new ArrayList<>();
        village1.add(new Village(TypeOfATU.VILLAGE,"Verhovina",162.4,9232,
                "Ivan", "Ivanov","head", "cattle"));
        village1.add(new Village(TypeOfATU.VILLAGE,"Viyki",20,41,
                "Sidor", "Sidorov","head", "harvest"));

        ArrayList<City>city1 = new ArrayList<>();
        city1.add(new City(TypeOfATU.CITY,"Dnepr",2000,115241,
                "Dmitriy", "Efremov","mayor", district1));
        city1.add(new City(TypeOfATU.CITY,"Poltava",1500,11524,
                "Bogdanov", "Bogdan","mayor", district2));

        Region region = new Region(TypeOfATU.REGION,"Dnipropetrovska", 22.3,10000,
                "Borys","Filatov","governor", city1,city1.get(0),village1);


        Region region1 = new Region(TypeOfATU.REGION,"Dnipropetrovska", 22.3,10000,
                "Borys","Filatov","governor", city1,city1.get(0),village1);
        region1.display();
        Region region2 = new Region(TypeOfATU.REGION,"Dnipropetrovska", 22.3,10000,
                "Alex","Voronin","Mer", city1,city1.get(0),village1);

        //WHEN
        boolean actual1 = region.equals(region1) && region1.equals(region);

        region1.setManager("Alex", "Voronin", "Mer");
        boolean actual2 = region1.equals(region2) && region2.equals(region1);

        //THEN
        Assert.assertTrue(actual1);
        Assert.assertTrue(actual2);
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void Input_WrongEnum_ExceptionThrown(){

        //GIVEN
        expectedEx.expect(RuntimeException.class);
        District d1 = new District();
        String s = "DISTRICT/Central/12.4/532/Alex/Voronin/manager";

        //WHEN
        d1.input(s);
    }
    @Test
    public void ChangeManager_IsChangeCorrect_True(){

        //GIVEN
        District district1 = new District(TypeOfATU.DISTRICT,"Central",12.4,532,
                "Alex", "Voronin","head");
        District district2 = new District(TypeOfATU.DISTRICT,"Central",12.4,532,
                "Sasha", "Kuhonokov","manager");

        Date data1 = new Date();
        Voting voting1 = new Voting("Local elections",data1);

        //WHEN
        voting1.changeManager(district2, "Alex", "Voronin", "head");
        boolean actual = district1.equals(district2) && district2.equals(district1);

        //THEN
        Assert.assertTrue(actual);

    }
}
