package models.pojo;

public class District extends AdministrativeTerritorialUnit {

    public District () {
        super();
    }

    public District (TypeOfATU typeOfATU, String title,  double square, int population,
                 String name, String surname, String postion) {
        super(typeOfATU,title,square, population, name,surname,postion);
    }

}
