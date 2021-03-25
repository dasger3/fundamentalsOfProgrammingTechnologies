package models.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.ListIterator;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class City extends AdministrativeTerritorialUnit {
    private ArrayList<District>district;

    public City (TypeOfATU typeOfATU, String title,  double square, int population,
                   String name, String surname, String position,
                   ArrayList <District>district) {
        super(typeOfATU,title,square, population, name,surname,position);
        this.district = district;
    }

    public City (TypeOfATU typeOfATU, String title,  double square, int population,
                 String name, String surname, String position) {
        super(typeOfATU,title,square, population, name,surname,position);
    }

    public String getPosition() {
        return super.getManager().getPosition();
    }

    public void addDistrict(District district) {
        this.district.add(district);
    }

}
