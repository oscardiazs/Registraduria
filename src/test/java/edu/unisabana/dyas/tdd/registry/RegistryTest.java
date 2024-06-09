package edu.unisabana.dyas.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();
    
    // Test 1 validar si puede votar con datos finales
    @Test
    public void validateRegistryResult() {
        Person person = new Person("Oscar",18760,18,Gender.MALE,true);
        //registry.registerVoter(person);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    // Test 2 validar si esta vivo
    @Test
    public void validateAlive() {
        Person person = new Person("Juan",18765,25,Gender.MALE,false);
        //registry.registerVoter(person);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    // Test 3 validar la edad del votante
    @Test
    public void validateAge() {
        Person person = new Person("Ana",18324,15,Gender.FEMALE,true);
        //registry.registerVoter(person);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    // Test 4 validar la edad mal con un numero negativo
    @Test
    public void validateNegativeAge() {
        Person person = new Person("Sofia",24625,-56,Gender.FEMALE,true);
        //registry.registerVoter(person);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    // Test 5 validar duplicado, se basa uniccamente en el ID
    @Test
    public void validateDuplicate() {
        Person person = new Person("Juan del Sur",99875,43,Gender.MALE,true);
        Person person1 = new Person("Juana del Sur",99875,54,Gender.FEMALE,true);
        //registry.registerVoter(person);
        //registry.registerVoter(person1);
        RegisterResult result = registry.registerVoter(person);
        RegisterResult result1 = registry.registerVoter(person1);
        Assert.assertEquals(RegisterResult.DUPLICATED, result1);
    }
    
}