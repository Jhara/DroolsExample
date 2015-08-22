package com.jara.drools.example;

import com.jara.drools.example.model.Firefighter;
import com.jara.drools.example.model.Person;
import com.jara.drools.example.model.Pet;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;

import static org.junit.Assert.*;

/**
 * Created by jara on 21/08/15.
 */
public class RuleTestTest {

    @Test
    public void existFireFigther(){
        Firefighter firefighter = new Firefighter();
        assertNotNull(firefighter);
    }

    @Test
    public void existPet(){
        Pet pet = new Pet();
        assertNotNull(pet);
    }

    @Test
    public void existPerson(){
        Person person = new Person();
        assertNotNull(person);
    }

    @Test
    public void createContainerfromclasspathTest(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        assertNotNull(kieContainer);
    }

    @Test
    public void sizeRulesTest(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        assertTrue(kieContainer.getKieBase().getKiePackage("com.jara.drools.example").getRules().size() == 3);
    }



}