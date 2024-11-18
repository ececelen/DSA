
public class DNode<T> {
	
    public T item;
    public DNode<T> prev; // Önceki düğüm
    public DNode<T> next; // Sonraki düğüm

    // Düğümün yapıcı fonksiyonu
    public DNode(T item) {
        this.item = item;
        this.prev = null;
        this.next = null;
    }

    // Veriyi almak için getter metodu
    public T getItem() {
        return item;
    }

    // Veriyi ayarlamak için setter metodu
    public void setItem(T item) {
        this.item = item;
    }

    // Önceki düğümü almak için getter metodu
    public DNode<T> getPrev() {
        return prev;
    }

    // Önceki düğümü ayarlamak için setter metodu
    public void setPrev(DNode<T> prev) {
        this.prev = prev;
    }

    // Sonraki düğümü almak için getter metodu
    public DNode<T> getNext() {
        return next;
    }

    // Sonraki düğümü ayarlamak için setter metodu
    public void setNext(DNode<T> next) {
        this.next = next;
    }
}