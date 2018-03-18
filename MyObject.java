package queue;

public class MyObject 
{
	private String name;
	private int priority;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int age) {
		this.priority = age;
	}
	
	public String toString() {
		return "<" + name + ", " + priority + ">";
	}

}