package com.jara.drools.example;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.jara.drools.example.model.Firefighter;
import com.jara.drools.example.model.Person;
import com.jara.drools.example.model.Pet;
import com.jara.drools.example.model.Pet.PetType;

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
    
    @Test
    public void firefighterCatTest(){
    	KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession =  kieContainer.newKieSession("FirefigtherCatKBase.session");
        Pet pet = new Pet("luluPerseo", "on a limb", PetType.CAT);
        Person person = new Person("Jhon");
        person.setPet(pet);                
        kieSession.insert(person);
        kieSession.insert(pet);
        kieSession.fireAllRules();
        kieSession.dispose();    	
    }
    
    @Test
    public void kbase1Test(){
    	KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession =  kieContainer.newKieSession("KBase1.session");
        kieSession.fireAllRules();
        kieSession.dispose();    
    }

    @Test
    public void kbaseDateTest(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession =  kieContainer.newKieSession("KBaseDate.session");
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    



}