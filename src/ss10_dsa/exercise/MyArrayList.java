package ss10_dsa.exercise;

import java.util.Arrays;

public class MyArrayList<E> {
    /**
     * Số lượng phần tử có trong MyArrayList
     */
    private int size = 0;
    /**
     * Sức chứa của MyArrayList
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * Mảng chứa các phần tử
     */
    Object elements[];

    /**
     * Sức chứa mặc định khi khởi tạo bằng constructor k có tham số
     */
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Phương thức constructor với sức chứa được truyền vào
     *
     * @param capacity
     * @throws IllegalAccessException
     */
    public MyArrayList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
    }

    /**
     * phương thức trả về số lượng phần tử
     *
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * phương thức clear ArrayList
     */
    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    /**
     * Phương tử add 1 phần tử vào MyArrayList
     *
     * @param element
     * @return
     */
    public boolean add(E element) {
        if (elements.length == size) {
            this.ensureCapacity(5);
        }
        elements[size] = element;
        size++;
        return true;
    }

    public void add(E element, int index) {
        if (index > elements.length) {
            throw new IllegalArgumentException("index: " + index);
        } else if (elements.length == size) {
            this.ensureCapacity(5);
        }

        if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            for (int i = size + 1; i > index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }
    }

    /**
     * Phương thức tăng kích thước của ArrayList
     *
     * @param minCapacity
     */
    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException("minCapacity: " + minCapacity);
        }
    }

    /**
     * Phương thức lấy 1 element tại vị trí index
     * @param index
     * @return
     */
    public E get(int index){
        return (E) elements[index];
    }

    public int indexOf(E element){
        int index = -1;
        for (int i = 0; i < size ; i++) {
            if(this.elements[i].equals(element)){
                return i;
            }
        }
        return index;
    }

}
