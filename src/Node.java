 class Node {

    String data;
    Node left,right;

    Node(String data){
        this.data=data;
        this.left=this.right=null;
    }
    public void addRight(Node toAdd){
        this.right=toAdd;
        return;
    }
    public void addLeft(Node toAdd){
        this.left=toAdd;
        return;
    }

}





class BinaryTree{
    Node root;

    BinaryTree(){
        this.root=null;
    }

    public void print(){
        System.out.println(this.root.data);
    }

    public static void main(String[] args) {
    BinaryTree b = new BinaryTree();
    Node root = new Node("1");
    Node l1 =  new Node("4");
    Node l2= new Node("3");
    Node r1 = new Node("10");
    Node rl1=new Node("4");
    r1.left=rl1;
    b.root=root;
    b.root.addLeft(l1);
    l1.addLeft(l2);
    b.root.addRight(r1);
        System.out.println(maxSum(b));
    }

    public static int maxSum(BinaryTree tree){
        return maxSum(tree.root);
    }

    public static int maxSum(Node root){
        if(root == null) return 0;
        return  Integer.parseInt(root.data) + Math.max(maxSum(root.left),maxSum(root.right));
    }
}
