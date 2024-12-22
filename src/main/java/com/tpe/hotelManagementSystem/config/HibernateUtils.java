package com.tpe.hotelManagementSystem.config;

import com.tpe.hotelManagementSystem.domain.Guest;
import com.tpe.hotelManagementSystem.domain.Hotel;
import com.tpe.hotelManagementSystem.domain.Reservation;
import com.tpe.hotelManagementSystem.domain.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    //session factory etkinleştirilmesi
    private static SessionFactory sessionFactory;
    static {
     try {
          Configuration config = new Configuration().configure().
                  addAnnotatedClass(Hotel.class).
                  addAnnotatedClass(Room.class).
                  addAnnotatedClass(Reservation.class).
                  addAnnotatedClass(Guest.class);
          SessionFactory sesssionFactory = config.buildSessionFactory();
      }catch (Exception e) {
         System.out.println("Initialization of session fatory is FAILLED!!!"+e.getMessage());
     }finally{
         HibernateUtils.shutDown();
        }

    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    //Session factory'i   kapatalım..
    public static void shutDown() {
        getSessionFactory().close();
    }
    //session 'ı kapatalım
    public static void closeSession(Session session) {
        if (session!=null && session.isOpen()) {
            session.close();
        }
    }







}


