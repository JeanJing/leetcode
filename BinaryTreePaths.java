import java.util.*;





public class BinaryTreePaths {
	public static void main(String args[]) {
		TreeNode node = new TreeNode(20);// �����new�Ļ���һ���������ڶ���Щ�����ѵ�û�г�ʼ���𣬵��Ǽǵ������еı���java�Ǹ����ʼ����
		if (node.left == null)
			System.out.println("jiayou");
		List<String> list1 = new LinkedList<String>();
		List<String> list2 = new LinkedList<String>();
		list1.add("jing");
		list1.add("zhen");
		list1.add("yan");// ��������Ļ���linkedlist��ÿ��addԪ�ض�����list��ĩβ
		System.out.println(list1);
		list2.add("will let");
		list2.add("chen");
		list2.add("love herself");
		System.out.println(list2);
		list1.addAll(list2);
		System.out.println(list1);// ����������������һ����
		String str = "jing";
		String str2 = "chen";
		System.out.println(str.concat(str2));// ���صĽ�������ˣ����ǵ��õ��ַ���������û�б�
		System.out.println(str);
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		List<String> list_5 = new LinkedList<String>();
		list_5 = binaryTreePaths(root);
		System.out.println(list_5);

	}

	public static List<String> binaryTreePaths(TreeNode root) {
		
		if (root == null) {
			return new LinkedList<String>();
		} else {
			List<String> list = new LinkedList<String>();
			if (root.left == null && root.right == null) {
				String str = Integer.toString(root.val);
				list.add(str);
			} else {
				List<String> leftList = new LinkedList<String>();
				List<String> rightList = new LinkedList<String>();
				leftList = binaryTreePaths(root.left);
				rightList = binaryTreePaths(root.right);
				// �ϲ�������������������·��
				list.addAll(leftList);
				list.addAll(rightList);

				String str;
				for (int i = 0; i < list.size(); i++) {
					str = list.get(i);
					String str_temp = Integer.toString(root.val)+"->";
					str = str_temp.concat(str);
					list.set(i, str);
				}
			}
			return list;
		}
		

	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
