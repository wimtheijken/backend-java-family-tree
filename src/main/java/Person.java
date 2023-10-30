import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private String middleName;
    private String lastName;
    private char sex;
    private int age;
    private Person mother; // (Person)
    private Person father; // (Person)
    private List<Person> siblings; //(lijst)
    private List<Person> children; //(lijst)
    private List<Pet> pets; // (lijst)

    public Person (String name, String lastName, int age, char sex) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public Person (String name, String middleName, String lastName, int age, char sex) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getMiddleName() { return middleName; }

    public void setMiddleName(String middleName) { this.middleName = middleName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public char getSex() { return sex; }

    public void setSex(char sex) { this.sex = sex; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public Person getMother() { return mother; }

    public void setMother(Person mother) { this.mother = mother; }

    public Person getFather() { return father; }

    public void setFather(Person father) { this.father = father; }

    public List<Person> getSiblings() { return this.siblings; }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }

    public List<Person> getChildren() { return this.children; }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public List<Pet> getPets() { return this.pets; }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void addParents(Person mother, Person father, Person child){
        child.setMother(mother);
        mother.addChildToChildren(mother, child);
        child.setFather(father);
        father.addChildToChildren(father, child);
    }

    public void addChildToChildren(Person parent, Person child){
        List<Person> kids = new ArrayList<>();
        if(parent.getChildren()!= null) {
            kids.addAll(parent.getChildren());
        }
        kids.add(child);
        parent.setChildren(kids);
    }

    public void addChild(Person person, Person child){
        List<Person> kids = new ArrayList<>();
        if(person.getChildren()!= null) {
            kids.addAll(person.getChildren());
        }
        kids.add(child);
        person.setChildren(kids);
    }

    public void addPet(Person person, Pet pet){
        List<Pet> pets = new ArrayList<>();
        if(person.getPets() != null){
            pets.addAll(person.getPets());
        }
        pets.add(pet);
        person.setPets(pets);
    }

    public void addSibling(Person person, Person sibling){
        List<Person> family = new ArrayList<>();
        if(person.getSiblings() != null){
            family.addAll(person.getSiblings());
        }
        family.add(sibling);
        person.setSiblings(family);
    }
    public List<Person> getGrandChildren(Person person){
        List<Person> grandChildren = new ArrayList<>();
        if(person.getChildren() != null) {
            for (Person children : person.getChildren()) {
                if (person.getChildren() != null) {
                    grandChildren.addAll(children.getChildren());
                }
            }
        }
        return grandChildren;
    }
}
