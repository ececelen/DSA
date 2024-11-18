import java.util.NoSuchElementException;

public class ArrayQueueofString {

	private String[] q;
	private int size;
	
	public ArrayQueueofString(int capacity) {
		q = new String[capacity];
		size = 0;
	}
	
	private void resize(int capacity) {
		String[] copy = new String[capacity];
		for(int i = 0; i < size; ++i) {
			copy[i] = q[i];
		}
		q = copy;
	}
	
	public void enqueue(String item) {
	    if (size == q.length) {
	        resize(2 * q.length); // Dizi doluysa kapasiteyi iki katına çıkar
	    }
	    q[size] = item; // Yeni elemanı kuyruğun sonuna ekle
	    ++size; // Kuyruk boyutunu artır
	}
	
	public String dequeue() {
	    if (isEmpty()) {
	        throw new NoSuchElementException("Queue is empty.");
	    }
	    String item = q[0]; // İlk elemanı (ön) al
	    for (int i = 0; i < size - 1; i++) {
	        q[i] = q[i + 1]; // Öğeleri sola kaydır
	    }
	    q[--size] = null; // Bellek sızıntısını önlemek için son elemanı null yap

	    if (size > 0 && size == q.length / 4) {
	        resize(q.length / 2); // Kullanım düşükse kapasiteyi yarıya indir
	    }
	    return item; // Çıkarılan elemanı döndür
	}

	
	public boolean isEmpty() {
		return size == 0;
	}
	
    public void printArrayQueue() {
        for (int i = 0; i < size; i++) {
            System.out.println(q[i]);
        }
    }
    
}