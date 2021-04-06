package voronin.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class City extends AdministrativeTerritorialUnit<District, District> {
    //private ArrayList<District>district;

    public City (TypeOfATU typeOfATU, String title,  double square, int population,
                   String name, String surname, String position,
                   ArrayList <District>district, Long center_id) {

        super(typeOfATU,title,square, population, name,surname,position);
        setCenter_id(center_id);
        setInternalList1(district);

    }

    public City (TypeOfATU typeOfATU, String title,  double square, int population,
                 String name, String surname, String position) {
        super(typeOfATU,title,square, population, name,surname,position);
        setInternalList1(new ArrayList<District>());

    }

    public String getPosition() {
        return super.getManager().getPosition();
    }

//    public void addDistrict(District district) {
//      this.district.add(district);
//    }

}
