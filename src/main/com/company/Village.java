package com.company;

public class Village extends AdministrativeTerritorialUnit implements Information{
    private String occupation;

    public Village (TypeOfATU typeOfATU, String title,  double square, int population,
                    String name, String surname, String postion,
                    String occupation) {
        super(typeOfATU,title,square, population, name,surname,postion);
        this.occupation = occupation;
    }

    public String getOccupation() {
        return occupation;
    }

    //@Override
    //public String toString() {
    //    return typeOfATU + " " + title;
    //}

    public void display() {
        super.display();
        System.out.println("Occupation of the village is " + occupation);
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
    }
}
