package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void fillDeletedElement(int index) {
        int numMoved = size - index -1;
        if(numMoved>0){
            System.arraycopy(storage,index+1, storage, index, numMoved);
        }
    }

    @Override
    protected void InsertElement(Resume resume, int index) {

        int insertInd = -index-1;
        System.arraycopy(storage, insertInd, storage, insertInd +1, size - insertInd);
        storage[insertInd] = resume;
    }
}
