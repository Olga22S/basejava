package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        boolean b = true;
        if (size != 0) {
            for (int j = 0; j < size; j++) {
                if (storage[j].getUuid().contains(r.getUuid())) {
                    System.out.println("Resume exists!");
                    storage[j] = r;
                    b = false;
                }
            }
        }
        if (b) {
            System.out.println("Resume does not exist!");
        }
    }

    public void save(Resume r) {
        boolean b = true;
        if (size == storage.length) {
            System.out.println("Memory is full!");
            b = false;
        }
        if (size != 0) {
            for (int j = 0; j < size; j++) {
                if (storage[j].getUuid().contains(r.getUuid())) {
                    System.out.println("Resume exists!");
                    b = false;
                    break;
                }
            }
        }
        if (b) {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
        for (int j = 0; j < size; j++) {
            if (storage[j].getUuid().contains(uuid)) {
                return storage[j];
            }
        }
        System.out.println(uuid + " does not exist!");
        return null;

    }

    public void delete(String uuid) {
        //check
        for (int j = 0; j < size; j++) {
            if (storage[j].getUuid().contains(uuid)) {
                storage[j] = null;
                for (; j < size; j++) {
                    storage[j] = storage[j + 1];
                }
            }
        }
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] resume = Arrays.copyOf(storage, size);
        return resume;
    }

    public int size() {
        return size;
    }
}
