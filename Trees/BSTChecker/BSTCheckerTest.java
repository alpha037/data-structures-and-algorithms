package Trees.BSTChecker;

public class BSTCheckerTest {
  public static void main(String[] args) {

    //        50
    //      /    \
    //    30      70
    //   /  \    /  \
    // 20   40  60   80

    TreeNode root = new TreeNode(50);

    root.left = new TreeNode(30);
    root.left.left = new TreeNode(20);
    root.left.right = new TreeNode(40);

    root.right = new TreeNode(70);
    root.right.left = new TreeNode(60);
    root.right.right = new TreeNode(80);

    // should be true
    System.out.println(BSTChecker.validateBST(root));
  }
}
