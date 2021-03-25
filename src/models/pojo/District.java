package models.pojo;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class District extends AdministrativeTerritorialUnit {

    public District (TypeOfATU typeOfATU, String title,  double square, int population,
                 String name, String surname, String position) {
        super(typeOfATU,title,square, population, name,surname,position);
    }

}
