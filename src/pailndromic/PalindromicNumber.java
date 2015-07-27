package pailndromic;

public class PalindromicNumber {

	public static void main(String[] args) {
		int palindromicNum, result;
		int x, y, z;
		int max = 0;

		for (int i = 999; i > 100; i--) {
			for (int j = 999; j > 100; j--) {
				
				if (i * j % 11 == 0) {
					palindromicNum = i * j / 11;
					x = palindromicNum / 9091;
					y = (palindromicNum % 9091) / 910;
					z = ((palindromicNum % 9091) % 910) / 100;

					result = (9091 * x) + (910 * y) + (100 * z);
					if (result == palindromicNum && (i * j) > max) {
						max = i * j;
					} 
				}
				
			} // for
		} // for
		System.out.println(max);
	}
}
