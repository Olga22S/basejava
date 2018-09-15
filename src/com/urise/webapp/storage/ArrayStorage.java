package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;


public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }


    public void save(Resume r) {
        boolean b = true;
        if (size == storage.length) {
            System.out.println("Memory is full!");
            b = false;
        }
        if (check(r.getUuid(), size) != null) {
            b = false;
            System.out.println("Resume exists!");
        }
        if (b) {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
        if (check(uuid, size) == null) {
            System.out.println(uuid + " does not exist!");
        }
        return check(uuid, size);
    }


    public void delete(String uuid) {
        boolean b = false;
        for (int j = 0; j < size; j++) {

            if (storage[j].getUuid().contains(uuid)) {
                storage[j] = null;
                b = true;
                for (; j < size; j++) {
                    storage[j] = storage[j + 1];
                }
            }
        }
        if (b) {
            size--;
        } else {
            System.out.println("Resume is not found!");
        }
    }

    public Resume[] getAll() {
        Resume[] resume = Arrays.copyOf(storage, size);
        return resume;
    }

    public int size() {
        return size;
    }

    public void update(Resume r) {
        Resume resume;
        if (check(r.getUuid(), size) != null) {
            resume = r;
        } else {
            System.out.println("Resume is not found!");
        }
    }

    private Resume check(String uuid, int size) {
        if (size != 0) {
            for (int j = 0; j < size; j++) {
                if (storage[j].getUuid().contains(uuid)) {
                    return storage[j];
                }
            }
        }
        return null;
    }
}
