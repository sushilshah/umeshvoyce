package com.voyce.infrastructure;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class VoyceEMF {
    private static final EntityManagerFactory emfInstance =
        Persistence.createEntityManagerFactory("transactions-optional");

    private VoyceEMF() {}
    
    public static EntityManagerFactory get() {
        return emfInstance;
    }
}