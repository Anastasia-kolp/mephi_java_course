package ru.mephi.lab1;

class Map {
    private int size = 0;
    private static final int container_size = 16;
    private Node[] values = new Node[container_size];

    private void largeCapacity(){
        if (size % container_size == 0){
            Node[] copying = new Node[size * 2];
            System.arraycopy(values, 0, copying, 0, size);
            size = size * 2;
            values = new Node[size];
            System.arraycopy(copying, 0, values, 0, size);
        }
    }

    public void put(Object key, Object value){
        if (key == null || value == null){
            System.err.println("Null value or key!");
        } else {
            if (size == 0){
                values[0] = new Node(key, value);
                size++;
            } else{
                largeCapacity();
                values[size] = new Node(key, value);
                size++;
            }
        }
    }

    public Object get(Object key){
        for (int i = 0; i < size; i++){
            if (values[i].getKey().equals(key))
                return values[i].getValue();
        }
        return null;
    }

    public Object get(Object key, Object bydefault){
        for (int i = 0; i < size; i++){
            if (values[i].getKey().equals(key))
                return values[i].getValue();
        }
        put(key, bydefault);
        return bydefault;
    }

    public Object remove(Object key){
        Object ret = null;
        for (int i = 0; i < size; i++){
            if (values[i].getKey().equals(key)){
                ret = values[i].getValue();
                values[i] = null;
                Node[] copying = new Node[size - 1];
                System.arraycopy(values, 0, copying, 0, i);
                System.arraycopy(values, i + 1, copying, i, size - i - 1);
                size--;
                //values = new Node[size];
                System.arraycopy(copying, 0, values, 0, size);
                break;
            }
        }
        for (int i = size; i < values.length; i++){
            values[i] = null;
        }
        return ret;
    }

    public boolean keyContains(Object key){
        if (size == 0)
            return false;
        for(int i = 0; i < size; i++){
            if (values[i].getKey().equals(key))
                return true;
        }
        return false;
    }

    public List getKeys(){
        Object[] keys = new Object[size];
        for (int i = 0; i < size; i++)
            keys[i] = values[i].getKey();
        List list = new List(keys);
        return list;
    }

    public List getValues(){
        Object[] a = new Object[size];
        for (int i = 0; i < size; i++)
            a[i] = values[i].getValue();
        List list = new List(a);
        return list;
    }

    public List getEntries(){
        Node[] entry = new Node[size];
        for (int i = 0; i < size; i++)
            entry[i]= values[i];
        List list = new List(entry);
        return list;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        if (this.size == 0)
            return true;
        return false;
    }

    public void print(){
        System.out.println("=====================================================");
        for(int i = 0; i < size; i++){
            System.out.println("Key: " + values[i].getKey() + " Value: " + values[i].getValue());
        }
        System.out.println("=====================================================");
    }

    public static void main(String[] args){
        Map mymap = new Map();
        System.out.println("Size: " + mymap.size());
        mymap.put(10, "Apple");
        mymap.put(1, "Orange");
        mymap.put(79, "Grape");
        mymap.put("Lemon", 80);
        mymap.print();
        List list = mymap.getKeys();
        list.print();
        List list1 = mymap.getValues();
        list1.print();
        List list2 = mymap.getEntries();
        list2.print();
        System.out.println("Val at 79 "+mymap.get(79));
        System.out.println("Val at 1 "+mymap.get(1));
        System.out.println("Val at 10 "+mymap.get(10));
        System.out.println("Val at 2 "+mymap.get(2));
        mymap.put(null, "Pear");
        System.out.println("Val at null "+mymap.get(null));
        System.out.println("Map has key at null:"+mymap.keyContains(null));
        System.out.println("Map has key at lemon:"+mymap.keyContains("Lemon"));
        System.out.println("Size of Map:"+mymap.size());
        System.out.println(mymap.remove(1));
        mymap.print();
        System.out.println("Map has key at 1:"+mymap.keyContains(1));
        System.out.println("Size of Map:"+mymap.size());
        mymap.get(79, "Pineapple");
        mymap.print();
        mymap.get(7, "Pineapple");
        mymap.print();
    }
}