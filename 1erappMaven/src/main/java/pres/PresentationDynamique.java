package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;
public class PresentationDynamique {
    public static void main(String[] args) throws Exception {

            Scanner scanner=new Scanner(new File("config.txt"));

            String daoClassname=scanner.next();
            String metierClassName=scanner.next();
            Class cdao=Class.forName(daoClassname);
            IDao dao= (IDao) cdao.newInstance();

            Class cmetier=Class.forName(metierClassName);
            IMetier metier=(IMetier) cmetier.newInstance();

            Method meth=cmetier.getMethod("setDao",IDao.class);

            meth.invoke(metier,dao);
            System.out.println(metier.calcul());
    }
}