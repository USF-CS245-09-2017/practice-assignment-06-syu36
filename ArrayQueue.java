
public class ArrayQueue<T> implements Queue<T> {
	private final int DEFAULT_SIZE = 10;
	private T[] arr;
	private int head;
	private int tail;

	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		head = 0;
		tail = 0;
		arr = (T[]) new Object[DEFAULT_SIZE];
	}

	@Override
	public void enqueue(T s) {
		if ((tail + 1) % arr.length == head) {
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

	@Override
	public boolean empty() {
		return head == tail;
	}

	@SuppressWarnings("unchecked")
	protected void growArray() {
		T[] temp = (T[]) new Object[arr.length * 2];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[head + i < arr.length ? head + i : (head + i) % arr.length];
		}
		head = 0;
		tail = arr.length - 1;
		arr = temp;
	}
}
