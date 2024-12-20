
public class Node <Key, Value>{

	public Key key;
	public Value value;
	public Node<Key, Value> left;
	public Node<Key, Value> right;

	
	public Node(Key key, Value value) {
		this.key = key;
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public Key getKey() {
		return key;
	}
	
	public void setKey(Key key) {
		this.key = key;
	}
	
	public Value getValue() {
		return value;
	}
	
	public void setValue(Value value) {
		this.value = value;
	}
	
	public Node<Key, Value> getLeft() {
		return left;
	}
	
	public void setLeft(Node<Key, Value> left) {
		this.left = left;
	}
	
	public Node<Key, Value> getRight() {
		return right;
	}
	
	public void setRight(Node<Key, Value> right) {
		this.right = right;
	}
	
}
