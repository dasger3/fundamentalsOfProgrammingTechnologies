package models.pojo;

import java.util.Objects;

public abstract class AdministrativeTerritorialUnit {
    private TypeOfATU typeOfATU;
    private String title;
    private double square;
    private int population;
    private Manager manager;

    AdministrativeTerritorialUnit() { }
    AdministrativeTerritorialUnit(TypeOfATU typeOfATU, String title,  double square, int population, String name, String surname, String postion) {
        this.typeOfATU = typeOfATU;
        this.title = title;
        this.square = square;
        this.population = population;
        manager = new Manager(name,surname,postion);
    }

    public TypeOfATU getTypeOfATU() {
        return typeOfATU;
    }

    public void setTypeOfATU(TypeOfATU typeOfATU) {
        this.typeOfATU = typeOfATU;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(String name, String surname, String position) {
        this.manager = new Manager(name,surname,position);
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

    public class Manager {
        String name;
        String surname;
        String position;

        public Manager(String name, String surname, String position) {
            this.name = name;
            this.surname = surname;
            this.position = position;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
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

    }
}
