package voronin.model;

import voronin.exception.ObjectNotFoundException;


public enum TypeOfATU {
        REGION ("Region"),
        DISTRICT ("District"),
        CITY ("City"),
        VILLAGE ("Village");

        private String title;

        TypeOfATU(String title) {
            this.title = title;
        }
//        public void setTitle(String title) {
//                this.title = title;
//        }

        public String getTitle() {
            return title;
        }

        public static TypeOfATU getTypeByUrl(String url) throws ObjectNotFoundException {
                for (TypeOfATU env : values()) {
                        if (env.getTitle().equals(url)) {
                                return env;
                        }
                }
                throw new ObjectNotFoundException(TypeOfATU.class.getName(), url);
        }

        @Override
        public String toString() {
            return title;
        }
}
