package models.pojo;

public class Village extends AdministrativeTerritorialUnit {
    private String occupation;

    public Village () {};
    public Village (TypeOfATU typeOfATU, String title,  double square, int population,
                    String name, String surname, String position,
                    String occupation) {
        super(typeOfATU,title,square, population, name,surname,position);
        this.occupation = occupation;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

}
