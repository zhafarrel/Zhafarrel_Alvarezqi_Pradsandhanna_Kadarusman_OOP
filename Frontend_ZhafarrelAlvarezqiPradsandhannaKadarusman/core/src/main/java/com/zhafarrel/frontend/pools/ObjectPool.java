package com.zhafarrel.frontend.pools;

import java.util.ArrayList;
import java.util.List;

public abstract class ObjectPool<T> {
    protected List<T> available = new ArrayList<>();
    protected List<T> inUse = new ArrayList<>();

    protected abstract T createObject();
    protected abstract void resetObject(T object);

    public T obtain(){
        T object;
        if(available.isEmpty()){
            object = createObject();
        }else{
            int lastidx = available.size() - 1;
            object = available.remove(lastidx);
        }
        inUse.add(object);
        return object;
    }

    public void release(T object){
        boolean removed = inUse.remove(object);
        if(removed){
            resetObject(object);
            available.add(object);
        }
    }

    public void releaseAll(){
        for(T object : new ArrayList<>(inUse)){
            resetObject(object);
            available.add(object);
        }
        inUse.clear();
    }

    public List<T> getInUse(){
        return new ArrayList<>(inUse);
    }

    public int getActiveCount(){
        return inUse.size();
    }
}
