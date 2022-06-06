package Ddao;

import InjectionAnotation.AmComponent;

@AmComponent
public class DaoImpl implements IDao {
    @Override
    public double getData() {
        //connextion base de donne pour recupirer la temperature
        System.out.println("version base de donnes");
        return Math.random()*40;
    }
}
