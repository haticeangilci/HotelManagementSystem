package com.tpe.hotelManagementSystem.repository;

import com.tpe.hotelManagementSystem.config.HibernateUtils;
import com.tpe.hotelManagementSystem.domain.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static org.postgresql.jdbc.PgConnection.ReadOnlyBehavior.transaction;

public class RoomRepository {

    private Session session;

    //4-c
    public void save(Room room) {

        try{
        session= HibernateUtils.getSessionFactory().openSession();
        Transaction t=session.beginTransaction();
        session.save(room);
        t.commit();



    }catch (Exception e){
            e.printStackTrace();
        }finally {
            HibernateUtils.closeSession(session);
        }
        }
}
