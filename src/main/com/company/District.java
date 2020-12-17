package com.company;

public class District extends AdministrativeTerritorialUnit implements Information{


    public District (TypeOfATU typeOfATU, String title,  double square, int population,
                 String name, String surname, String postion) {
        super(typeOfATU,title,square, population, name,surname,postion);
    }
    public District () {
        super();
    }
    public void input(String str) throws WrongInputException {
        //System.out.println("You can set info for district. Enter it in format: ");
        //System.out.println("TypeOfATU/Title/Square/Population/Name/Surname/Position");
        //String str;
        String []dis;
        try {
            dis = str.split("/",7);
            if (dis.length<7) throw new WrongInputException("Too short input");
            super.setManager(dis[4], dis[5],dis[6]);
            super.title = dis[1];
            super.population = Integer.valueOf(dis[3]);
            super.square = Double.valueOf(dis[2]);
            super.typeOfATU = TypeOfATU.getTypeByUrl(dis[0]);
        }
        catch (WrongInputException e) {
            System.out.println(e);
            throw e;
        }
    }

    public void display() {
        super.display();
    }
}
