/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.park.parkinglot.ejb;

import com.park.parkinglot.common.BonDetails;
import com.park.parkinglot.entity.Bon;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mihal
 */
@Stateless
public class PaymentBean {

    private static final Logger LOG = Logger.getLogger(PaymentBean.class.getName());

    @PersistenceContext
    private EntityManager em;

    public int createBon(ArrayList<String> produse) {
        LOG.info("createBon");
        Bon bon = new Bon();
        bon.setProdusCod(produse);
        em.persist(bon);

        return bon.getId();
    }

    public BonDetails findBonById(int idBon) {
        LOG.info("findBon");
        try {

            Bon bon = em.find(Bon.class, idBon);
            return new BonDetails(bon.getId(), bon.getProdusCod());

        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
//
//    private BonDetails copyBonToDetails(Bon b) {
//        BonDetails detailsList;
//
//        BonDetails bonDetails = new BonDetails(
//                b.getId(),
//                b.getProdusCod());
//        detailsList = bonDetails;
//
//        return detailsList;
//    }

//    public void updateCar(Integer carId, String licensePlate, String parkingSpot, Integer userId) {
//        LOG.info("updateCar");
//        Car car = em.find(Car.class, carId);
//        car.setLicensePlate(licensePlate);
//        car.setParkingSpot(parkingSpot);
//
//        //remove this car from old owner
//        User oldUser = car.getUser();
//        oldUser.getCars().remove(car);
//
//        //add the car ti its new user
//        User user = em.find(User.class, userId);
//        user.getCars().add(car);
//        car.setUser(user);
//
//        //em.persist(car);
//    }
//    public void deleteCarsByIds(Collection<Integer> ids) {
//        LOG.info("deleteCarsByIds");
//        for (Integer id : ids) {
//            Car car = em.find(Car.class, id);
//            em.remove(car);
//        }
//    }
}
