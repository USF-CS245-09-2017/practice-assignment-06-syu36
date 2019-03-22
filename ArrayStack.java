/**
 *
 * A stack implementation that uses an array as the set of data. This array grows by doubling each time the array fills up.
 *
 * @param <T> Type of the ArrayStack
 */
public class ArrayStack<T> implements Stack<T> {
	private final int DEFAULT_SIZE = 10;
	private T[] arr;
	private int top;

	@SuppressWarnings("unchecked")
	/**
	 * Initializes the top of the stack and the array.
	 */
	public ArrayStack() {
		arr = (T[]) new Object[DEFAULT_SIZE];
		top = -1;
	}


	@Override
	public T pop() {
		if (empty()) {
			try {
				throw new Exception("Stack is empty.");
			} catch (Exception e) {
				System.err.println("Stack is empty, cannot pop.");
			}
		}

		return arr[top--];
	}

	@Override
	public T peek() {
		if (empty()) {
			try {
				throw new Exception("Stack is empty.");
			} catch (Exception e) {
				System.err.println("Stack is empty, cannot peek.");
			}
		}

		return arr[top];
	}

	@SuppressWarnings("unchecked")
	@Override
	public void push(Object t) {
		if (top + 1 == arr.length) {
			growArray();
		}

		arr[++top] = (T) t;
	}

	@Override
	public boolean empty() {
		return top == -1;
	}

	@SuppressWarnings("unchecked")
	/**
	 * Doubles the size of the array and copies over elements from the stack.
	 */
	protected void growArray() {
		T[] temp = (T[]) new Object[arr.length * 2];

		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}

		arr = temp;
	}

}
