package voronin.model;

import lombok.*;

import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
@NoArgsConstructor
public class Region extends AdministrativeTerritorialUnit<City, Village> {
    //private ArrayList<City>city;
    //private ArrayList<Village>village;
    //private City regionCenter;


    public Region (TypeOfATU typeOfATU, String title,  double square, int population,
                   String name, String surname, String position,
                   ArrayList<City>city,ArrayList<Village>village, Long center_id) {
        super(typeOfATU,title,square, population, name,surname,position);
        setCenter_id(center_id);
        setInternalList1(city);
        setInternalList2(village);
    }
    public Region (TypeOfATU typeOfATU, String title,  double square, int population,
                   String name, String surname, String position) {
        super(typeOfATU,title,square, population, name,surname,position);
        setInternalList1(new ArrayList<City>());
        setInternalList2(new ArrayList<Village>());
    }

    @Override
    public String toString() {
        return super.toString();
    }
    //    public void addCity (City city) {
//        getInternalList1().add(city);
//    }
//    public void addVillage (Village village) {
//        getInternalList2().add(village);
//    }
}
