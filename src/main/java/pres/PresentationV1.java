package pres;

import dao.DaoImpl;
import metier.MetierImpl;

public class PresentationV1 {

    public static void main(String[] args) {

        /**
         * Injection des dépendances par instanciation statique =
         */
        DaoImpl dao = new DaoImpl();
        MetierImpl metier = new MetierImpl(dao); // Injection via le constructeur
        //metier.setDao(dao); // Injection via le setter
        System.out.println("RES:"+metier.calcul());
    }
}
