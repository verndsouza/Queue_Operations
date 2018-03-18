package queue;

public interface Queues

{
	boolean add(MyObject obj);

	MyObject remove();

	int getCount();

	void clear();

	MyObject peek();

	boolean isEmpty();

	boolean isFull();
}
