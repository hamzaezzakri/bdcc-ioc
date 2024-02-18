package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PresentationV2 {

    public static void main(String[] args) {

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("config.txt"));

            //DaoImpl dao = new DaoImpl();
            String daoClassName = scanner.nextLine();
            Class cDao =  Class.forName(daoClassName);
            IDao dao = (IDao) cDao.getConstructor().newInstance();

            //MetierImpl metier = new MetierImpl(dao);
            String metierClassName = scanner.nextLine();
            Class cMetier = Class.forName(metierClassName);

            //IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);
            IMetier metier = (IMetier) cMetier.getConstructor().newInstance();

            //metier.setDao(dao);
            Method setDao = cMetier.getDeclaredMethod("setDao", IDao.class);
            setDao.invoke(metier, dao);

            System.out.println("RES:"+metier.calcul());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
