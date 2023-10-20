import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {
    // 1. arrange:
    // 2. act:
    // 3. assert:
    @Test
    void getNameTest() {
        Pet pet = new Pet("Kees", 10, "Pitbull");
        assertEquals("Kees", pet.getName());
    }

    @Test
    void setNameTest() {
        Pet pet = new Pet("Kees", 10, "Pitbull");
        pet.setName("Boefje");
        assertEquals("Boefje", pet.getName());
    }

    @Test
    void getAgeTest() {
        Pet pet = new Pet("Kees", 10, "Pitbull");
        assertEquals(10, pet.getAge());
    }

    @Test
    void setAgeTest() {
        Pet pet = new Pet("Kees", 10, "Pitbull");
        pet.setAge(12);
        assertEquals(12, pet.getAge());
    }

    @Test
    void getSpeciesTest() {
        Pet pet = new Pet("Kees", 10, "Pitbull");
        assertEquals("Pitbull", pet.getSpecies());
    }

    @Test
    void setSpeciesTest() {
        Pet pet = new Pet("Kees", 10, "Pitbull");
        pet.setSpecies("Poedel");
        assertEquals("Poedel", pet.getSpecies());
    }

    @Test
    void getOwnerTest() {
        Pet pet = new Pet("Kees", 10, "Pitbull");
        Person owner = new Person("Marietje",  "Flodder", 33, 'v');
        pet.setOwner(owner);
        assertEquals(owner, pet.getOwner());
    }

    @Test
    void setOwnerTest() {
        Pet pet = new Pet("Kees", 10, "Pitbull");
        Person owner = new Person("Marietje",  "Flodder", 33, 'v');
        pet.setOwner(owner);
        String ownerName = pet.getOwner().getName();
        assertEquals("Marietje", ownerName);
    }
}