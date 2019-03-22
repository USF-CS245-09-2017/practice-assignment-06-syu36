
public class ArrayQueue<T> implements Queue<T> {

	private T[] arr;
	private int head;
	private int tail;

	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		head = 0;
		tail = 0;
		arr = (T[]) new Object[10];
	}

	@Override
	public void enqueue(T s) {
		if ((head + 1) % arr.length == tail) {
			growArray();
		}
		arr[tail] = s;
		tail = (tail + 1) % arr.length;
	}

	@Override
	public T dequeue() {
		if (empty()) {
			try {
				throw new Exception("Queue is empty.");
			} catch (Exception e) {
				System.err.println("Queue is empty, cannot dequeue.");
			}
		}
		T temp = arr[head];
		head = (head + 1) % arr.length;
		return temp;
	}

	//	@Override
	//	public T toString() {
	//		String s = "";
	//		for (String item : arr) {
	//			s += item + ", ";
	//		}
	//		s += "\nHead: " + head + "\nTail: " + tail;
	//		return s;
	//	}

	@Override
	public boolean empty() {
		return head == tail;
	}

	@SuppressWarnings("unchecked")
	protected void growArray() {
		System.out.println("Queue growing");
		System.out.println("Queue size: " + arr.length);
		T[] temp = (T[]) new Object[arr.length * 2];
		for (int i = 0; i < arr.length; i++) {
			//			System.out.println(head + i < arr.length ? head + i: head + i % arr.length);
			temp[i] = arr[head + i < arr.length ? head + i : (head + i) % arr.length];
		}
		arr = temp;
	}

	//	public static void main(String[] args) {
	//		ArrayQueue<String> queue = new ArrayQueue<>();
	//		queue.enqueue("A");
	//		queue.enqueue("B");
	//		queue.dequeue();
	//		queue.enqueue("C");
	//		System.out.println(queue);
	//
	//
	//	}
}
