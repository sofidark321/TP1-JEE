package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres2 {
    public static void main(String[] args) throws Exception {
        try {
            //1
            Scanner scanner = new Scanner(new File("src/config.txt"));
            //2
            String daoClassName = scanner.nextLine();
            String metierClassName = scanner.nextLine();
            //3
            Class cDao = Class.forName(daoClassName);
            Class cMetier = Class.forName(metierClassName);
            //4
            IDao dao = (IDao) cDao.newInstance();
            IMetier metier = (IMetier) cMetier.newInstance();
            //5
            Method method = cMetier.getMethod("setDao", IDao.class);
            method.invoke(metier, dao);
            System.out.println("resultat:" + metier.calcul());
        }catch (Exception e){e.printStackTrace();}

    }
}