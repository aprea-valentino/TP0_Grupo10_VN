package Ej_2_6_5.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomDictionary implements MultipleDictionary {

    private KeyNode first;
    private int count;
    private final Random random;

    public RandomDictionary() {
        this.first = null;
        this.count = 0;
        this.random = new Random();
    }

    @Override
    public void add(int key, int value) {
        KeyNode current = this.first;
        while (current != null && current.getKey() != key) {
            current = current.getNext();
        }
        if (current == null) {
            this.first = new KeyNode(key, this.first, new Node(value, null));
            this.count++;
            return;
        }

        Node currentAux = current.getValues();
        while (currentAux.getNext() != null) {
            currentAux = currentAux.getNext();
        }
        currentAux.setNext(new Node(value, null));
    }

    @Override
    public void remove(int key, int value) {
        if (this.first == null) {
            return;
        }
        if (this.first.getNext() == null) {
            if (this.first.getKey() == key) {
                if (this.first.getValues().getNext() == null) {
                    if (this.first.getValues().getValue() == value) {
                        this.first = null;
                        this.count--;
                        return;
                    }
                }
                delete(this.first.getValues(), value);
                return;
            }
            return;
        }

        if (this.first.getKey() == key) {
            if (this.first.getValues().getNext() == null) {
                if (this.first.getValues().getValue() == value) {
                    this.first = this.first.getNext();
                    this.count--;
                }
                return;
            }
            delete(this.first.getValues(), value);
            return;
        }

        KeyNode backup = this.first;
        KeyNode current = this.first.getNext();
        while (current != null && current.getKey() != key) {
            backup = current;
            current = current.getNext();
        }

        if (current != null) {
            if (current.getKey() == key) {
                if (current.getValues().getNext() == null) {
                    if (current.getValues().getValue() == value) {
                        backup.setNext(current.getNext());
                        this.count--;
                    }
                    return;
                }
                delete(this.first.getValues(), value);
            }
        }
    }

    @Override
    public Set getKeys() {
        Set set = new DynamicSet();
        if (this.first == null) {
            return set;
        }

        KeyNode current = this.first;
        while (current.getNext() != null) {
            set.add(current.getKey());
            current = current.getNext();
        }

        set.add(current.getKey());

        return set;
    }

    @Override
    public List<Integer> get(int k) {
        KeyNode current = this.first;
        while (current != null) {
            if (current.getKey() == k) {
                List<Integer> list = new ArrayList<>();
                Node node = current.getValues();
                while (node != null) {
                    list.add(node.getValue());
                    node = node.getNext(); // Agregado para mover al siguiente nodo
                }
                return list;
            }
            current = current.getNext(); // Agregado para mover al siguiente nodo
        }
        throw new RuntimeException("No se encontró la clave");
    }

    public int getRandomValue(int k) {
        List<Integer> values = get(k);
        if (values.isEmpty()) {
            throw new RuntimeException("No hay valores asociados a la clave");
        }
        int randomIndex = random.nextInt(values.size());
        return values.get(randomIndex);
    }

    private void delete(Node node, int value) {
        Node backup = node;
        Node current = node.getNext();
        while (current.getNext() != null) {
            if (current.getValue() == value) {
                backup.setNext(current.getNext());
                return;
            }
            backup = current;
            current = current.getNext();
        }
        if (current.getValue() == value) {
            backup.setNext(current.getNext());
        }
    }
}
