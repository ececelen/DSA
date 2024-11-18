
public class DLinkedList<T> {
	
    private DNode<T> head; // Listenin başı
    private DNode<T> tail; // Listenin sonu
    private int size; // Listenin boyutu

    // Constructor: Yeni bir liste oluşturur ve boyutu 0 olarak başlatır
    public DLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0; // Başlangıçta boyut 0
    }

    // Listenin başına yeni bir düğüm ekler
    public void addFirst(T item) {
        DNode<T> newNode = new DNode<T>(item);
        if (head == null) { // Liste boşsa
            head = tail = newNode;
            newNode.setPrev(null);
            newNode.setNext(null);
        } else { // Liste boş değilse
            newNode.setNext(head);
            head.setPrev(newNode);
            newNode.setPrev(null);
            head = newNode;
        }
        size++; // Boyutu arttır
    }
    
    // Listenin sonuna yeni bir düğüm ekler
    public void addLast(T item) {
        DNode<T> newNode = new DNode<T>(item);
        if (tail == null) { // Liste boşsa
            head = tail = newNode;
            newNode.setPrev(null);
            newNode.setNext(null);
        } else { // Liste boş değilse
            tail.setNext(newNode);
            newNode.setPrev(tail);
            newNode.setNext(null);
            tail = newNode;
        }
        size++; // Boyutu arttır
    }
    
    // Belirtilen düğümden sonra yeni bir düğüm ekler
    public void addAfter(DNode<T> after, T item) {
        if (after == null) 
        	return; // Eğer düğüm null ise işlem yapma

        DNode<T> newNode = new DNode<T>(item);
        newNode.setNext(after.getNext());
        newNode.setPrev(after);
        
        if (after.getNext() != null) {
            after.getNext().setPrev(newNode);
        } else {
            tail = newNode; // Yeni düğüm son düğümse, kuyruğu güncelle
        }
        after.setNext(newNode);
        size++; // Boyutu artır
    }
    
    // Listenin başındaki düğümü kaldırır ve kaldırılan düğümü döndürür
    public DNode<T> removeFirst() {
        if (head == null) 
        	return null; // Liste boşsa null döndür

        DNode<T> removedNode = head; // Kaldırılan düğümü sakla
        if (head == tail) { // Tek bir düğüm varsa
            head = tail = null;
        } else {
            head = head.getNext();
            head.setPrev(null);
        }
        size--; // Boyutu azalt
        return removedNode;
    }

    // Listenin sonundaki düğümü kaldırır ve kaldırılan düğümü döndürür
    public DNode<T> removeLast() {
        if (tail == null) 
        	return null; // Liste boşsa null döndür

        DNode<T> removedNode = tail; // Kaldırılan düğümü sakla
        if (head == tail) { // Tek bir düğüm varsa
            head = tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        size--; // Boyutu azalt
        return removedNode;
    }

    // Verilen düğümden sonraki düğümü kaldırır ve kaldırılan düğümü döndürür
    public DNode<T> removeAfter(DNode<T> after) {
        if (after == null || after.getNext() == null) 
        	return null; // Sonraki düğüm yoksa null döndür

        DNode<T> removedNode = after.getNext(); // Kaldırılan düğümü sakla
        after.setNext(removedNode.getNext());

        if (removedNode.getNext() != null) {
            removedNode.getNext().setPrev(after);
        } else {
            tail = after; // Eğer kaldırılan düğüm son düğümse, kuyruğu güncelle
        }
        size--; // Boyutu azalt
        return removedNode;
    }

    // Listedeki tüm düğümleri yazdırır
    public void printList() {
        DNode<T> temp = head;
        while (temp != null) {
            System.out.print(temp.getItem() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }
    
}