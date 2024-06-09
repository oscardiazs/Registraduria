package edu.unisabana.dyas.tdd.registry;

import java.util.HashSet;
import java.util.Set; // Se usa para tener un registro

public class Registry {

    private Set<Integer> registroPvalidado = new HashSet<>();

    public RegisterResult registerVoter(Person p) {
        
        // Si se indica que la persona no esta viva
        if (!p.isAlive()) {
            return RegisterResult.DEAD;
        }
        // La persona no puede ser menor de 18 anos
        if (p.getAge() > 0 && p.getAge() < 18) {
            return RegisterResult.UNDERAGE;
        }
        // La persona debe tener entre 18 y 120 anos segun nuestro caso
        if (p.getAge() < 18 || p.getAge() > 120) {
            return RegisterResult.INVALID_AGE;
        }
        // Si ya el registro fue hecho anteriormente
        if (registroPvalidado.contains(p.getId())) {
            return RegisterResult.DUPLICATED;
        }
        // Si no se ha regresado nigun otro valor, la persona es valida
        registroPvalidado.add(p.getId());
        return RegisterResult.VALID;
    }
    
}