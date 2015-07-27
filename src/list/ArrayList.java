package list;

public class ArrayList {

	private int size = 0;
	private Object[] elementData = new Object[100];

	public ArrayList() {

	}

	public boolean addLast(Object element) {
		elementData[size] = element;
		size++;
		return true;
	}

	public static void main(String[] args) {

		ArrayList numbers = new ArrayList();

	}
}
