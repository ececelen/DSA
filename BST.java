
public class BST<Key extends Comparable<Key>, Value> {
	
    private Node<Key, Value> root;

    public BST() {
        this.root = null;
    }
    
    public Value get(Key key) {
    	Node<Key, Value> x = root; // Aramaya kök düğümden başla
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
            	x = x.left; // Anahtar küçükse sol alt ağaca ilerle
            } else if (cmp > 0) {
            	x = x.right; // Anahtar büyükse sağ alt ağaca ilerle
            } else {
                return x.value; // Anahtar bulundu, değeri döndür
            }
        }
        return null; // Anahtar bulunamazsa null döner
    }
    
    public void put(Key key, Value value) {
    	root = put(root, key, value);
    }
    
    private Node<Key, Value> put(Node<Key, Value> x, Key key, Value value) {
    	if (x == null) return new Node<Key, Value>(key, value);
    	int cmp = key.compareTo(x.key);
    	if (cmp < 0) {
    		x.left = put(x.left, key, value);
    	} else if (cmp > 0) {
    		x.right = put(x.right, key, value);
    	} else {
    		x.value = value;
    	}
    	return x;
    }
    
    public Node<Key, Value> findMin(Node<Key, Value> x) {
        if (x.left == null) return x;
        return findMin(x.left);
    }

    public Node<Key, Value> findMax(Node<Key, Value> x) {
        if (x.right == null) return x;
        return findMax(x.right);
    }


    public void preOrder(Node<Key, Value> x) {
    	if (x == null) return;
    	System.out.println(x.value);
    	preOrder(x.left);
    	preOrder(x.right);
    }
    
    public void postOrder(Node<Key, Value> x) {
    	if(x == null) return;
    	postOrder(x.left);
    	postOrder(x.right);
    	System.out.println(x.value);
    }
    
    public void inOrder(Node<Key, Value> x) {
    	if (x == null) return;
    	inOrder(x.left);
    	System.out.println(x.value);
    	inOrder(x.right);
    }
    
    public void count() {
    	count(root);
    }
    
    private int count(Node<Key, Value> x) {
    	if (x == null) return 0;
    	return 1 + count(x.left) + count(x.right);
    }
    
    public Node<Key, Value> deleteMin(Node<Key, Value> x) {
    	if (x.left == null) return x.right;
    	x.left = deleteMin(x.left);
    	return x;
    }
    
    public Node<Key, Value> deleteMax(Node<Key, Value> x) {
    	if (x.right == null) return x.left;
    	x.right = deleteMax(x.right);
    	return x;
    }
    
    public Node<Key, Value> delete(Node<Key, Value> x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key); 
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.left == null) {
                return x.right;
            }
            if (x.right == null) {
                return x.left;
            }
            Node<Key, Value> temp = x;
            x = findMin(x.right);
            x.right = deleteMin(x.right);
            x.left = temp.left;
        }
        return x;
    }

}
