package demo;

public class Person {

	private final String firstName;
	private final String lastName;
	private Dog dog = new Dog();

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getFullName() {
		return this.firstName + "" + this.lastName;
	}

	public Person cloneWithdifferentName(String firstName){
		return new Person(firstName, this.lastName);
	}

}
