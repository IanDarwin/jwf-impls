package com.darwinsys.jwf.model;

import java.util.ArrayList;
import java.util.List;

/** 
 * A completely toy DAO implementation: in-memory only!
 * @author Ian Darwin
 */
public class PersonDaoMemory implements PersonDao {
    
    List<Person> frontingStore = new ArrayList<Person>(100);
    
    public PersonDaoMemory() {
        // empty
    }
    
    @Override
    public boolean insert(Person p) {
        boolean ok = frontingStore.add(p);
        // XXX should save to a backing store too!
        return ok;
    }

    @Override
    public List findAll() {
        return frontingStore;
    }
}
