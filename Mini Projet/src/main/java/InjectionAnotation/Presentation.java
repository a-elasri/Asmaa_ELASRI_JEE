package InjectionAnotation;

import metier.Imetier;

import java.lang.reflect.InvocationTargetException;

public class Presentation {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
    ConfigurationAnotattion contx=new ConfigurationAnotattion();
    contx.getClasses("Ddao", "metier");
    Imetier imetier= (Imetier) contx.getInstances().get(Imetier.class);

        System.out.println(imetier.calcule());
}}

