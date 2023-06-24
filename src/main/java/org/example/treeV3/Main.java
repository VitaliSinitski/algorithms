package org.example.treeV3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Data> items = new ArrayList<>();

        items.add(new Data(1, "Соки", 0));
        items.add(new Data(2, "Манго", 1));
        items.add(new Data(3, "Виноградный", 1));
        items.add(new Data(4, "Яблочный", 1));
        items.add(new Data(5, "Газировка", 0));
        items.add(new Data(6, "Кола", 5));
        items.add(new Data(7, "Кола 0.5л", 6));
        items.add(new Data(8, "Кола 1.5л", 6));
        items.add(new Data(9, "Минералка", 5));
        items.add(new Data(10, "Лимонад", 5));
    }

    public static class Data {
        int id;
        String name;
        int parentId;

        public Data(int id, String name, int parentId) {
            this.id = id;
            this.name = name;
            this.parentId = parentId;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
