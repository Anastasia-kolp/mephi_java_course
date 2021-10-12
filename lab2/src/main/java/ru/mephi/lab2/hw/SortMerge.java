package ru.mephi.lab2.hw;

public class SortMerge {
    private static boolean isSorted(ListInt list) {
        for (int i = 0; i < list.getSize() - 1; i++) {
            if (list.get(i) > list.get(i + 1))
                return false;
        }
        return true;
    }

    public ListInt merge(ListInt src1, ListInt src2) {
        if (!(isSorted(src1) && isSorted(src2)))
            throw new IllegalArgumentException("Lists don't sorted!");
        else {
            int posSrc1 = 0;
            int posSrc2 = 0;
            ListInt result = new ListInt();
            while (posSrc1 < src1.getSize() && posSrc2 < src2.getSize()) {
                if (src1.get(posSrc1) < src2.get(posSrc2)) {
                    result.add(src1.get(posSrc1), posSrc1 + posSrc2);
                    posSrc1++;
                } else {
                    result.add(src2.get(posSrc2), posSrc1 + posSrc2);
                    posSrc2++;
                }
            }
            while (posSrc1 < src1.getSize()) {
                result.add(src1.get(posSrc1), posSrc1 + posSrc2);
                posSrc1++;
            }
            while (posSrc2 < src2.getSize()) {
                result.add(src2.get(posSrc2), posSrc1 + posSrc2);
                posSrc2++;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        SortMerge test = new SortMerge();
        ListInt list1 = new ListInt(1, 2, 6, 7, 9, 68);
        System.out.println("List #1: " + list1);
        ListInt list2 = new ListInt(0, 1, 4, 5, 8, 9, 12);
        System.out.println("List #2: " + list2);
        try {
            ListInt result = test.merge(list1, list2);
            System.out.println("Result: " + test.merge(list1, list2));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
