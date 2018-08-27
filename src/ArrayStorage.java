import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
private int size;

    void clear() {
        int i=0;
        Arrays.fill(storage, i, size(), null);
        size = 0;
    }

    void save(Resume r)  {
        storage[size]=r;
        size++;
    }

    Resume get(String uuid) {
        Resume r = new Resume();
        for(int j =0;j<storage.length;j++) {
            if (storage[j] != null) {
                if (storage[j].uuid.contains(uuid)) {
                    r.uuid = uuid;
                }
            }
        }
        return r;
    }

    void delete(String uuid) {
        for(int j =0;j<storage.length;j++){
            if(storage[j]!=null) {
                if(storage[j].uuid.contains(uuid)){
                    storage[j]=null;
                }
            }
        }
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resume = new Resume[size];

        for(int i =0;i<storage.length;i++) {
            if(storage[i]==null) {
                for(int j=i+1;j<storage.length;j++) {
                    if(storage[j]!=null) {
                        Resume m = storage[i];
                        storage[i]=storage[j];
                        storage[j]=m;;
                        break;
                    }
                }
            }
        }
        resume = Arrays.copyOf(storage, size);
        return resume;
    }

    int size() {
        return size;
    }
}
