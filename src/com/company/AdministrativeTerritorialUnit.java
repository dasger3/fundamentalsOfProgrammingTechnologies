package com.company;

import java.util.Objects;

public abstract class AdministrativeTerritorialUnit implements Information {
    TypeOfATU typeOfATU;
    String title;
    double square;
    int population;
    private Manager manager;


    AdministrativeTerritorialUnit(TypeOfATU typeOfATU, String title,  double square, int population,
                                         String name, String surname, String postion) {
        this.typeOfATU = typeOfATU;
        this.title = title;
        this.square = square;
        this.population = population;
        manager = new Manager(name,surname,postion);
    }

    AdministrativeTerritorialUnit() { }

    public void setManager(String name, String surname, String position) {
        manager = new Manager(name,surname,position);
    }
    public Manager getManager() {
        return manager;
    }

    public int getPopulation() {
        return population;
    }

    public double getSquare() {
        return square;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        AdministrativeTerritorialUnit guest = (AdministrativeTerritorialUnit) obj;
        return typeOfATU == guest.typeOfATU && square == guest.square && population == guest.population && manager.equals(guest.manager)
                && (Objects.equals(title, guest.title))
                ;
    }


    public void display () {
        StringBuilder str = new StringBuilder();
        str.append(typeOfATU).append(" ").append("Title: ").append(title).append(" | Square: ").append(square).append(" | Population: ").append(population);
        System.out.println(str);
        manager.display();
    }

    public class Manager {
        String name;
        String surname;
        String position;

        public Manager(String name, String surname, String position) {
            this.name = name;
            this.surname = surname;
            this.position = position;
        }

        public String getPosition() {
            return position;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }
            Manager guest = (Manager) obj;
            return (Objects.equals(name, guest.name)) &&
                   (Objects.equals(surname, guest.surname)) &&
                   (Objects.equals(position, guest.position));
        }

        void display () {
            StringBuilder str = new StringBuilder();
            str.append("Position: ").append(position).append(" of ").append(title).append(" ").append(typeOfATU.getTitle())
               .append(" | Name: ").append(name).append(" | Surname: ").append(surname);
            System.out.println(str);
            System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        }


    }


}
