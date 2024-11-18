
public class LinkedQueue<T> {
	
    private DNode<T> head; // Kuyruğun başındaki düğüm
    private DNode<T> tail; // Kuyruğun sonundaki düğüm
    private int size; // Kuyruk boyutu

    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    // Kuyruğa eleman ekleme (enqueue)
    public void enqueue(T item) {
        DNode<T> newNode = new DNode<T>(item);
        if (isEmpty()) {
            head = tail = newNode; // Kuyruk boşsa, hem head hem tail yeni düğüm olur
        } else {
            tail.setNext(newNode); // Eski tail'in next'ini yeni düğüme bağla
            newNode.setPrev(tail); // Yeni düğümün prev referansı eski tail olur
            tail = newNode; // Yeni düğüm tail olur
        }
        size++;
    }

    // Kuyruktan eleman çıkarma (dequeue)
    public T dequeue() {
        if (isEmpty()) {
            return null; // Kuyruk boşsa
        }
        T item = head.getItem();
        head = head.getNext(); // Head'i bir sonraki düğüme kaydır
        if (head != null) {
            head.setPrev(null); // Yeni head'in prev referansını null yap
        } else {
            tail = null; // Kuyruk boşaldıysa, tail de null olur
        }
        size--;
        return item;
    }

    // Kuyruk boş mu kontrolü
    public boolean isEmpty() {
        return size == 0;
    }
}
