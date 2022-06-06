package extention;

import Ddao.IDao;

public class DaoImpl2 implements IDao {
    //version capteur
    @Override
    public double getData() {
        System.out.println("version capture");
        return 4000;
    }
}
