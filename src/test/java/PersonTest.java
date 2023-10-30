import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    // 1. arrange:
    // 2. act:
    // 3. assert:
//    @BeforeEach
//    void setUp() {
//        Person father = new Person("Theo", "Hoogendijk", 67, 'm');
//    }

    @Test
    void addParents() {
        Person mother = new Person("Marietje",  "Flodder", 43, 'v');
        Person father = new Person("Piet",  "Flodder", 47, 'm');
        Person child = new Person("Job",  "Flodder", 10, 'm');
        child.addParents(mother,father,child);
        assertEquals(father,child.getFather());
        assertEquals(mother,child.getMother());
    }

    @Test
    void addChild() {
        Person mother = new Person("Marietje",  "Flodder", 43, 'v');
        Person father = new Person("Piet",  "Flodder", 47, 'm');
        Person child = new Person("Job",  "Flodder", 10, 'm');
        Person child2 = new Person("Truus",  "Flodder", 9, 'v');
        mother.addChild(mother, child);
        mother.addChild(mother, child2);
        father.addChild(father, child);
        father.addChild(father, child2);
        assertEquals("Job", mother.getChildren().get(0).getName());
        assertEquals("Truus", mother.getChildren().get(1).getName());
        assertEquals("Job", father.getChildren().get(0).getName());
        assertEquals("Truus", father.getChildren().get(1).getName());
        assertEquals(2, mother.getChildren().size());
        assertEquals(2, father.getChildren().size());
    }

    @Test
    void addPet() {
        Person person = new Person("Marietje",  "Flodder", 43, 'v');
        Pet pet = new Pet("Kees", 10, "Pitbull");
        Pet pet2 = new Pet("Minoes", 4, "cats");
        List<Pet> pets = new ArrayList<>();
        pets.add(pet);
        pets.add(pet2);
        person.addPet(person, pet);
        person.addPet(person, pet2);
        assertEquals(pets, person.getPets());
    }

    @Test
    void addSibling() {
        List<Person> sibblings = new ArrayList<>();
        Person person1 = new Person("Piet", "Pietersen", 34, 'x');
        Person person2 = new Person("Jade", "Pietersen", 22, 'v');
        Person person3 = new Person("Marie", "Pietersen", 22, 'v');
        sibblings.add(person3);
        sibblings.add(person2);
        person1.addSibling(person1, person3);
        person1.addSibling(person1, person2);
        assertEquals(sibblings, person1.getSiblings());
    }

    @Test
    void getGrandChildren() {
        List<Person> grandChildren = new ArrayList<>();
        Person person1 = new Person("Jay Jay", "Pietersen", 3, 'v');
        Person person2 = new Person("James", "Pietersen", 22, 'm');
        Person person3 = new Person("Jan", "Pietersen", 64, 'm');
        grandChildren.add(person1);
        person2.addChildToChildren(person2, person1);
        person3.addChildToChildren(person3, person2);
        List<Person> list = person3.getGrandChildren(person3);
        assertEquals(grandChildren, list);
    }

    @Test
    void getSetName() {
        Person person = new Person("Marietje",  "Flodder", 33, 'v');
        person.setName("Truus");
        assertEquals("Truus", person.getName());
    }

    @Test
    void getSetMiddleName() {
        Person person = new Person("Marietje", "van der" ,  "Flodder", 33, 'v');
        person.setMiddleName("van de");
        assertEquals("van de", person.getMiddleName());
    }

    @Test
    void getSetLastName() {
        Person person = new Person("Marietje", "Flodder", 33, 'v');
        person.setLastName("Broek");
        assertEquals("Broek", person.getLastName());
    }

    @Test
    void getSetSex() {
        Person person = new Person("Marietje", "Flodder", 33, 'v');
        person.setSex('m');
        assertEquals('m', person.getSex());
    }

    @Test
    void getSetAge() {
        Person person = new Person("Marietje", "Flodder", 33, 'v');
        person.setAge(64);
        assertEquals(64, person.getAge());
    }

    @Test
    void gatSetMother() {
        Person mother = new Person("Marietje", "Flodder", 63, 'v');
        Person child = new Person("Piet", "Flodder", 34, 'x');
        child.setMother(mother);
        Person mama = child.getMother();
        assertEquals(mother, mama);
    }

    @Test
    void getSetFather() {
        Person father = new Person("Dirk", "Flodder", 73, 'm');
        Person child = new Person("Piet", "Flodder", 34, 'x');
        child.setFather(father);
        Person papa = child.getFather();
        assertEquals(father, papa);
    }

    @Test
    void getSiblings() {
        Person person1 = new Person("Piet", "Pietersen", 34, 'x');
        Person person2 = new Person("Jade", "Pietersen", 22, 'v');
        Person person3 = new Person("James", "Pietersen", 27, 'm');
        List<Person> kids = new ArrayList<>();
        kids.add(person2);
        kids.add(person3);
        person1.setSiblings(kids);
        List<Person> siblings = person1.getSiblings();
        assertEquals(kids, siblings);
    }

    @Test
    void getChildren() {
        Person person1 = new Person("Piet", "Pietersen", 34, 'x');
        Person person2 = new Person("Jade", "Pietersen", 22, 'v');
        Person person3 = new Person("James", "Pietersen", 27, 'm');
        Person father = new Person("Jan", "Pietersen", 64, 'm');
        List<Person> kids = new ArrayList<>();
        kids.add(person2);
        kids.add(person3);
        kids.add(person1);
        father.setChildren(kids);
        List<Person> children = father.getChildren();
        assertEquals(kids, children);
    }

    @Test
    void getPets() {
        Person person = new Person("Marietje", "Flodder", 33, 'v');
        Pet pet = new Pet("Kees", 10, "Pitbull");
        Pet pet2 = new Pet("Wodan", 10, "Rottweiler");
        List<Pet> pets = new ArrayList<>();
        pets.add(pet);
        pets.add(pet2);
        person.setPets(pets);
        List<Pet> animals = person.getPets();
        assertEquals(pets, animals);
    }
}