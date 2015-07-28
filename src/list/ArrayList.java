package list;

interface ArrayInterface {
	public void add(Object o);

	public void add(int index, Object o);

	public void removeAll();

	public boolean remove(Object o);

	public boolean remove(int idx);

	public int size();
}

class ArrayList implements ArrayInterface {
	Object[] myArray;

	ArrayList() {
		myArray = new Object[20];
	}

	public int size() {
		for (int i = 0; i < myArray.length; i++) {
			if (myArray[i] == null)
				return i;
		}
		return myArray.length;
	}

	public void add(Object s) {
		myArray[size()] = s;
	}

	public void add(int index, Object s) {
		if (index < size()) {
			for (int i = size(); i > index; i--) {
				myArray[i] = myArray[i - 1];
			}
			myArray[index] = s;
		}
	}

	public boolean remove(int idx) {
		int size = size();
		if (idx < size) {
			myArray[idx] = null;
			for (int i = idx; i < size - 1; i++) {
				myArray[i] = myArray[i + 1];
				myArray[i + 1] = null;
			}
			return true;
		}
		return false;
	}

	public boolean remove(Object s) {
		int i = 0, idx = 0, size = 0;
		size = size();
		for (i = 0; i < size; i++) {
			if (myArray[i].equals(s)) {
				idx = i;
				break;
			}
		}

		if (i == size) {
			System.out.println("Data Not F...????");
			return false;
		}

		if (idx < size) {
			myArray[idx] = null;
			for (i = idx; i < size - 1; i++) {
				myArray[i] = myArray[i + 1];
				myArray[i + 1] = null;
			}
			return true;
		}
		return false;
	}

	public void removeAll() {
		for (int i = 0; i < size(); i++) {
			myArray[i] = null;
		}
	}

	public String toString() {
		String s = "[";
		for (int i = 0; i < size(); i++) {
			s = s + myArray[i];
			if (i != size() - 1) {
				s = s + ", ";
			}
		}
		s = s + "]";
		return s;
	}

	public static void main(String[] args) {

		ArrayList array = new ArrayList();
		array.add("First");
		array.add("Second");
		array.add("Third");
		System.out.println(array); // First, Second, Third 의 출력 요구.
		array.remove("Third");
		System.out.println(array); // First, Second 의 출력 요구.
		array.remove(0);
		System.out.println(array); // Second의 출력 요구.
		array.add(0, "Zero");
		System.out.println(array); // Zero, Second의 출력 요구.
	}

}
