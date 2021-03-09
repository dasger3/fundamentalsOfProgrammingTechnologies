package models.pojo;

import models.exceptions.ATUNotFoundException;

public enum TypeOfATU {
        REGION ("Region"),
        DISTRICT ("District"),
        CITY ("City"),
        VILLAGE ("Village");

        private String title;

        TypeOfATU(String title) {
            this.title = title;
        }
        //public void setTitle(String title) {
        //        this.title = title;
        //}

        public String getTitle() {
            return title;
        }

        public static TypeOfATU getTypeByUrl(String url) throws ATUNotFoundException {
                for (TypeOfATU env : values()) {
                        if (env.getTitle().equals(url)) {
                                return env;
                        }
                }
                throw new ATUNotFoundException("No enum found with url: [" + url + "]");
        }

        @Override
        public String toString() {
            return "Type of territorial unit: " + title + " | ";
        }
}
