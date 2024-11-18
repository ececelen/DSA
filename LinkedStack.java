
public class LinkedStack<T> {
	
    private DNode<T> top; // Yığının en üstündeki düğüm
    private int size; // Yığın boyutu

    public LinkedStack() {
        top = null;
        size = 0;
    }

    // Yığına eleman ekleme (push)
    public void push(T item) {
        DNode<T> newNode = new DNode<T>(item);
        newNode.setNext(top); // Yeni düğüm eski top'u gösterecek
        if (top != null) {
            top.setPrev(newNode);
        }
        top = newNode; // Yeni düğüm artık top
        size++;
    }

    // Yığından eleman çıkarma (pop)
    public T pop() {
        if (isEmpty()) {
            return null; // Yığın boşsa
        }
        T item = top.getItem();
        top = top.getNext(); // Top'u bir aşağıya indir
        if (top != null) {
            top.setPrev(null); // Yeni top'un prev referansı null
        }
        size--;
        return item;
    }

    // Yığın boş mu kontrolü
    public boolean isEmpty() {
        return size == 0;
    }
}


