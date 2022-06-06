package metier;

import Ddao.IDao;
import InjectionAnotation.AmAutowired;
import InjectionAnotation.AmComponent;
@AmComponent
public class ImetierImpl implements Imetier {
    @AmAutowired
    private IDao dao; //couplage faible
    @Override
    public double calcule() {
        return dao.getData()*540/Math.cos(Math.PI*40);
    }
//injecter dans la variable dao un objet d'une clas qui implement l'interface dao
 public void setDao(IDao dao) {
        this.dao = dao;
    }
}
