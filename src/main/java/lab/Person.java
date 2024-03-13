package lab;

public class Person implements Comparable<Person> {

    //Atributes for the class
    String name;
    String lastName;
    String id;

    /**
     * Empty constructor
     */
    public Person(){

    }

    /**
     * Constructor
     * @param name
     * @param lastName
     * @param id
     */
    public Person(String name, String lastName, String id) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
    }

    //Implement getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * toString function for person class
     * @return
     */
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    /**
     * compareTo method for persons
     * @param person
     * @return
     */
    @Override
    public int compareTo(Person person) {
        return id.compareTo(person.id);
    }

    //Methods for the lab -----------------------------------------------------------

    /**
     * Return's even if the length of the id is even
     * @return
     */
    public boolean isIdEven() {
        return this.id.length() % 2 == 0;
    }
}
