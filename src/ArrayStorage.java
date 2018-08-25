import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r)  {

        for(int i=0;i<storage.length;i++) {
            if(storage[i]==null) {
                storage[i]=r;
                break;}
            else if(storage[i]!=null){
                if(storage[i].uuid.contains(r.uuid)) {
                    System.out.println("This resume is already exist");
                    break ;
                }
            }
        }
    }

    Resume get(String uuid) {
        Resume r = new Resume();
        r.uuid = "not found";
        for(int j =0;j<storage.length;j++)
            if(storage[j]!=null)
                if(storage[j].uuid.contains(uuid))
                    r.uuid = uuid;
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
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        Resume[] resume = new Resume[size()];

        for(int j=0;j<size();j++)
            for(int i =0;i<storage.length;i++)
                if((storage[i]!=null)) {
                    resume[j]=storage[i];
                    j++;
                    continue;
                }else continue;
        return resume;
    }

    int size() {
        int size=0;
        for(int i =0;i<storage.length;i++) {
            if(!(storage[i]==null))
                size++;
        }
        return size;
    }
}
