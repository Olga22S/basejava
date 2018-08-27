import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;

    void clear() {
        Arrays.fill(storage, 0, size(), null);
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int j = 0; j < size; j++) {
            if (storage[j].uuid.contains(uuid)) {
                return storage[j];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int j = 0; j < size(); j++) {

            if (storage[j].uuid.contains(uuid)) {
                storage[j] = null;
                for (int i = j; j < size(); j++) {
                    storage[j] = storage[j + 1];
                }
            }
        }

        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resume = Arrays.copyOf(storage, size);
        return resume;
    }

    int size() {
        return size;
    }
}
