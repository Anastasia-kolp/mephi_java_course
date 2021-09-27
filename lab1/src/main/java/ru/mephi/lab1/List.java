package ru.mephi.lab1;

class List {

    Object[] value;
    int size;

    List(){
        this.size = 0;
    }

    List(Object ... copying){
        size = copying.length;
        value = new Object[size];
        System.arraycopy(copying, 0, value, 0, size);
    }

    /*List(int size){
        if (size < 0) {
            return;
        }
        this.size = size;
        value = new Object[size];
    }*/

    public void add(Object value){
        if (value == null){
            System.out.println("Not null value!");
            return;
        }
        Object[] adding = new Object[size + 1];
        System.arraycopy(this.value, 0, adding, 0, size);
        adding[size] = value;
        size++;
        this.value = new Object[size];
        System.arraycopy(adding, 0, this.value, 0, size);
    }

    public Object remove(int index){
        if (index >= size || index < 0)
            return null;
        Object[] result = new Object[size - 1];
        Object returning = this.value[index];
        System.arraycopy(this.value, 0, result, 0, index);
        System.arraycopy(this.value, index + 1, result, index, this.size - index - 1);
        this.size--;
        this.value = new Object[size];
        System.arraycopy(result, 0, this.value, 0, size);
        return returning;
    }

    public void add(Object adding, int index){
        if (value == null){
            System.out.println("Not null value!");
            return;
        }
        if (index > size) {
            System.err.println("The index must be less than or equal to the size of the list.");
            return;
        }
        if (index == size) {
            add(adding);
        } else{
            Object[] result = new Object[size + 1];
            result[index] = adding;
            System.arraycopy(this.value, 0, result, 0, index);
            System.arraycopy(this.value, index, result, index + 1, this.size - index);
            this.size++;
            System.arraycopy(result, 0, this.value, 0, size);
        }
    }

    public Object get(int index){
        if (index >= size || index < 0){
            return null;
        }
        else {
            return this.value[index];
        }
    }

    public int indexOf(Object value){
        int index = -1;
        for(int i = 0; i < size; i++){
            if (this.value[i] == value){
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean contains(Object value){
        if (value == null){
            System.out.println("Not null value!");
            return false;
        }
        for (int i = 0; i < size; i++){
            if (this.value[i] == value)
                return true;
        }
        return false;
    }

    public Object set(Object value, int index){
        if (index >= size || index < 0 || value == null)
            return null;
        Object ret = this.value[index];
        this.value[index] = value;
        return ret;
    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        if (size == 0)
            return true;
        return false;
    }

    public void print(){
        System.out.println("=====================================================");
        for(int  i = 0; i < size; i++){
            System.out.println(value[i]);
        }
        System.out.println("=====================================================");
    }

    public static void main(String[] args){
        List list = new List(5, 6, 7, 10, 12);
        list.print();
        System.out.println(list.getSize());
        list.remove(2);
        list.print();
        System.out.println(list.getSize());
        list.add(68);
        list.add(54, 7);
        list.print();
        System.out.println(list.getSize());
        System.out.println(list.contains(12));
        System.out.println(list.contains(7));
    }
}
