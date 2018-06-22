
package queue;

import java.util.Scanner;

public class Queue {
	private final int QUEUE_SIZE = 50;
	static MyObject []queue;
	int head;
	int tail;
	int count;
	int index=0;
	private static Scanner sc;
	
	public Queue() {
		queue = new MyObject[QUEUE_SIZE];
		head = tail = count = 0;
	}
	
	public Queue(int size) {
		queue = new MyObject[size];
		head = tail = count = 0;
	}
	
	public void enqueue(String name, int priority)
	{
		MyObject obj = new MyObject();
		obj.setName(name);
		obj.setPriority(priority);
		add(obj);
	}
	
	public MyObject remove() {
		
		if (count == 0) {
			return null;
		} else {
			MyObject n = queue[index];
			head++;
			if (head == queue.length) {
				head = 0;
			}
			count--;
			return n;
		}
	}
	
	public boolean add(MyObject obj) {
		
		if (isFull()) {
			return false;
		}
		
		if (count == 0) {
			queue[count] = obj;
			// Every time we empty the queue restart it at 0
			head = count;
			tail = head + 1;
			if (tail == queue.length) {
				tail = 0;
			}
		} else {
			queue[tail++] = obj;
			if (tail == queue.length) {
				tail = 0;
			}
		}
		
		count++;
		return true;
	}
	public boolean isFull() {
		return count == queue.length;
	}
	
	public String toString() {
		String rtn = "";
		if (count == 0) {
			rtn = "<Empty>";
		} else {
			int h = head;
			while (h != tail) {
				rtn += queue[h] + " ";
				h++;
				if (h == queue.length) {
					h = 0;
				}
			}
		}
		return rtn;
	}

	public String deQueue()
	{
		
		int max=queue[0].getPriority();
		for(int i =1; i<count;i++)
		{
			if(queue[i].getPriority() > max)
			{
				max=queue[i].getPriority();
				System.out.println(max);
				index=i;
			}
		}
		String z = queue[index].getName();
		MyObject x = new MyObject();
		MyObject y = new MyObject();
		x.setName(queue[0].getName());
		x.setPriority(queue[0].getPriority());
		y.setName(queue[index].getName());
		y.setPriority(queue[index].getPriority());
		queue[index]=x;
		queue[0]=y;
		remove();
		return z;
		
		
	}
	public boolean isEmpty() {
		return count == 0;
	}



	public static void main(String[] args) {
		Queue Q = new Queue();
		
		int choice = 0 ;
		sc = new Scanner(System.in);
		do {


		System.out.println("Choose: 1. Enqueue 2. Dequeue 3. Empty 4. View 5. End");
		choice = sc.nextInt();
		if(choice == 1)
		{
			sc = new Scanner(System.in);
			System.out.println("Enter Name: ");
			String name=sc.nextLine();
			System.out.println("Enter Priority: ");
			int priority=sc.nextInt();

			Q.enqueue(name,priority);
		}
		else if(choice == 2)
		{
			System.out.println(Q.deQueue());


		}
		else if(choice == 3){
			System.out.println(Q.isEmpty());
		}
		else if(choice == 4)
		{
			System.out.println(Q);

		}
		}
		while(choice!=5);

	}

}
