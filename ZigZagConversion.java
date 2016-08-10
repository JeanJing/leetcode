import java.util.Arrays;

public class ZigZagConversion {
	public static void main(String args[]) {
		String str = "jingzhenyanjidkdjghfjdke12345689";
		System.out.println(numberOfLetter("AB", 1));
		System.out.println(convert("PAYPALISHIRING", 3));
	}

	public static String numberOfLetter(String s, int numRows) {
		char[] str = s.toCharArray();
		int numberOfLetter = str.length;// �ַ����ܸ���
		char[] convertedStr = new char[numberOfLetter];
		if (numberOfLetter == 0)
			return "";
		if (numRows == 1)
			return s;
		int line = numberOfLetter / (2 * numRows - 2);
		int lineIncomplete = numberOfLetter % (2 * numRows - 2);
		;// ת����������±�
			// ��ÿ��Ԫ�ص�һ����ʼ����Ĭ��Ϊ���Ա�������û������
		int lineOfEachRow[] = new int[numRows];
		lineOfEachRow[0] = line;
		lineOfEachRow[numRows - 1] = line;
		Arrays.fill(lineOfEachRow, 1, numRows - 1, 2 * line);

		if (lineIncomplete != 0) {// û�б����������
			for (int i = 0; i < numRows; i++) {
				if (i > lineIncomplete - 1) {
					// �����κδ���
				} else if (i <= lineIncomplete - 1
						&& 2 * numRows - i - 2 > lineIncomplete - 1 || i == 0
						&& i <= lineIncomplete - 1 || i == numRows - 1
						&& i <= lineIncomplete - 1) {
					lineOfEachRow[i] = lineOfEachRow[i] + 1;
				} else if (2 * numRows - i - 2 <= lineIncomplete - 1) {
					lineOfEachRow[i] = lineOfEachRow[i] + 2;
				}
			}
		}
		// ������Ϊֹÿһ��Ӧ���м���Ԫ���Ѿ�����׼ȷ�õ�

		int row = 0;
		int counterRow = 0;

		int firstInterval = 2 * (numRows - 2);
		int secondInterval = 2;
		int eveyRowInterval_1;
		int eveyRowInterval_2;
		int index = 0;
		for (int i = 0; i < numberOfLetter; i++) {
			if (row == 0 || row == numRows - 1) {
				if (counterRow < lineOfEachRow[row]) {
					convertedStr[i] = str[row + (2 * numRows - 2) * counterRow];
					counterRow++;
				} else {
					row++;
					index = row;
					convertedStr[i] = str[index];
					counterRow = 1;
				}

			} else {
				eveyRowInterval_1 = firstInterval - 2 * (row - 1);
				eveyRowInterval_2 = secondInterval + 2 * (row - 1);
				if (counterRow < lineOfEachRow[row]) {
					if (counterRow % 2 == 1) {
						index += eveyRowInterval_1;
					} else {
						index += eveyRowInterval_2;
					}
					convertedStr[i] = str[index];
					counterRow++;
				} else {
					row++;
					index = row;
					convertedStr[i] = str[index];
					counterRow = 1;
				}

			}

		}

		return String.valueOf(convertedStr);

	}

	public static String convert(String s, int nRows) {
		if (s == null || s.length() == 0 || nRows <= 1)
			return s;
		char arr[] = s.toCharArray();
		char carr[] = new char[arr.length];

		int step = nRows * 2 - 2;
		int zcnt = arr.length / step;
		int k = 0;
        //�ұ���������ֳɺ�С�Ĳ��ֲ�����⡢�����������������
		for (int i = 0; i < nRows; i++) {//����ѭ������һ��ѭ���õ����У��ڶ���ѭ���õ��ǵõ��ĳ�ʼ��������һ�к����һ�У�
			for (int j = 0; j <= zcnt; j++) {
				if (i == 0) {//�������������һ�С��ڶ����Լ�������
					if (j * step < arr.length)
						carr[k++] = arr[j * step];
				} else if (i == nRows - 1) {
					if (j * step + i < arr.length)
						carr[k++] = arr[j * step + i];
				} else {
					if (j * step + i < arr.length)
						carr[k++] = arr[j * step + i];
					if ((j + 1) * step - i < arr.length)
						carr[k++] = arr[(j + 1) * step - i];

				}
			}

		}
		return new String(carr);
	}

}
