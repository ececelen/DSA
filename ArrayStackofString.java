import java.util.NoSuchElementException;

public class ArrayStackofString {

	private String[] s;
	private int size;
	
	public ArrayStackofString (int capacity) {
		s = new String[capacity];
		size = 0;
	}
/*	
	public void push (String item) {
		s[size] = item;
		++ size;
	}
	
	public String pop () {
		String last = s[size-1];
		-- size;
		return last;
	}
*/	
    private void resize (int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }
    
    public void push(String item) {
        if (size == s.length) {
            resize(2 * s.length);  // Dizi doluysa kapasiteyi iki katına çıkar
        }
        s[size] = item;  // Yeni elemanı diziye ekle
        ++size;  // Yığın boyutunu artır
    }
    
    public String pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        String last = s[--size];  // Son elemanı al ve size'ı bir azalt
        s[size] = null;  // Bellek sızıntısını önlemek için eski referansı temizle

        if (size > 0 && size == s.length / 4) {
            resize(s.length / 2);  // Kullanım düşükse kapasiteyi yarıya indir
        }
        return last;  // Çıkarılan elemanı döndür
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
	
    public void printArrayStack() {
        for (int i = 0; i < size; i++) {
            System.out.println(s[i]);
        }
    }
}