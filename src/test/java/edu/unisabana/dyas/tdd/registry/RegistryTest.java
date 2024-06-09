package edu.unisabana.dyas.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();
    @Test
    public void validateRegistryResult() {
        Person person1 = new Person("Oscar",18764,18,Gender.MALE,false);
        registry.registerVoter(person1);
        RegisterResult result = registry.registerVoter(person1);
        Assert.assertEquals(RegisterResult.VALID, result);
    }
    // TODO Complete with more test cases
}