package metier;

import dao.DaoImpl;
import dao.IDao;
import ext.DaoImpl2;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier{
 //Couplage faible
   private IDao dao;
    public MetierImpl(IDao dao) {

        this.dao = dao;
    }

    @Override
    public double calcul() {
        double tmp=dao.getData();
        double res=tmp*540/Math.cos(tmp*Math.PI);
        return res;
    }
/* Injecter dans la variable dao un objet d'une classe qui implemente l'injection IDao*/
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
