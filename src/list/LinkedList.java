package list;

public class LinkedList {
	// 첫번째 노드를 가리키는
	private Node head;
	private Node tail;
	private int size = 0;

	private class Node {
		private Object data;
		private Node next;

		public Node(Object input) {
			this.data = input;
			this.next = null;
		}

	}

	public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head;
		// 헤드로 새로운 노드를 지정.
		head = newNode;
		size++;
		if (head.next == null) {
			tail = head;
		}
	}

	public void addLast(Object input) {
		Node newNode = new Node(input);
		// 리스트의 노드가 없다면 첫번째 노드를 추가하는 메소드를 사용...
		if (size == 0) {
			addFirst(input);
		} else {
			tail.next = newNode;
			// 마지막 노드를 갱신.
			tail = newNode;
			// 엘리먼트의 개수를 1 증가.
			size++;
		}
	}

	Node node(int index) {
		Node x = head;
		for (int i = 0; i < index; i++)
			x = x.next;
		return x;
	}

	public void add(int k, Object input) {
		if (k == 0) {
			addFirst(input);
		} else {
			Node temp1 = node(k - 1);
			Node temp2 = temp1.next;
			Node newNode = new Node(input);
			temp1.next = newNode;
			newNode.next = temp2;
			size++;
			// 새로운 노드의 다음 노드가 없다면 새로운 노드가 마지막 노드이기 때문에 tail로 지정.
			if (newNode.next == null) {
				tail = newNode;
			}
		}
	}

	public String toString() {
		if (head == null) {
			return "[]";
		}
		Node temp = head;
		String str = "[";
		// 마지막 노드는 다음 노드가 없기 때문에 아래의 구문은 마지막 노드는 제외.
		while (temp.next != null) {
			str += temp.data + ",";
			temp = temp.next;
		}
		// 마지막 노드를 출력결과에 포함.
		str += temp.data;
		return str + "]";
	}

	public Object removeFirst() {
		// 첫번째 노드를 temp로 지정하고 head의 값을 두번째 노드로 변경.
		Node temp = head;
		head = temp.next;
		Object returnData = temp.data;
		temp = null;
		size--;
		return returnData;
	}

	public Object remove(int k) {
		if (k == 0)
			return removeFirst();
		Node temp = node(k - 1);
		Node todoDeleted = temp.next;
		temp.next = temp.next.next;
		Object returnData = todoDeleted.data;
		if (todoDeleted == tail) {
			tail = temp;
		}
		todoDeleted = null;
		size--;
		return returnData;
	}

	public Object removeLast() {
		return remove(size - 1);
	}

	public int size() {
		return size;
	}

	public Object get(int k) {
		Node temp = node(k);
		return temp.data;
	}

	public int indexOf(Object data) {
		// 탐색 대상이 되는 노드를 temp로 지정.
		Node temp = head;
		// 탐색 대상이 몇번째 엘리먼트에 있는지를 의미하는 변수로 index를 사용.
		int index = 0;
		while (temp.data != data) {
			temp = temp.next;
			index++;
			if (temp == null)
				return -1;
		}
		return index;
	}

	public ListIterator listIterator() {
		return new ListIterator();
	}

	class ListIterator {
		private Node lastReturned;
		private Node next;
		private int nextIndex;

		ListIterator() {
			next = head;
			nextIndex = 0;
		}

		// 본 메소드를 호출하면 next의 참조값이 기존 next.next로 변경더ㅗ니.
		public Object next() {
			lastReturned = next;
			next = next.next;
			nextIndex++;
			return lastReturned.data;
		}

		public boolean hasNext() {
			return nextIndex < size();
		}

		public void add(Object input) {
			Node newNode = new Node(input);
			if (lastReturned == null) {
				head = newNode;
				newNode.next = next;
			} else {
				lastReturned.next = newNode;
				newNode.next = next;
			}
			lastReturned = newNode;
			nextIndex++;
			size++;
		}

		public void remove() {
			if (nextIndex == 0) {
				throw new IllegalStateException();
			}
			LinkedList.this.remove(nextIndex - 1);
			nextIndex--;
		}

	}

}