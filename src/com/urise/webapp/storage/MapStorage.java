package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

   private Map<String, Resume> map = new HashMap<>();


    @Override
    protected Resume doGet(Object searchKey) {
        return null;
    }

    @Override
    protected void doSave(Resume resume, Object searchKey) {

    }

    @Override
    protected boolean isExist(Object searchKey) {
        return false;
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {

    }

    @Override
    protected Object getSearchKey(String uuid) {
        return null;
    }

    @Override
    protected void doDelete(Object searchKey) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }
}
