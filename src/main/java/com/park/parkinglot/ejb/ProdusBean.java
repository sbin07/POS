/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.park.parkinglot.ejb;

import com.park.parkinglot.common.ProdusDetails;
import com.park.parkinglot.entity.Produs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ValidationException;

/**
 *
 * @author mihal
 */
@Stateless
public class ProdusBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private static final Logger LOG = Logger.getLogger(ProdusBean.class.getName());

    @PersistenceContext
    private EntityManager em;

    public ArrayList<Produs> findByIds(Collection<String> produsCod) {

        Query query = em.createQuery("SELECT p FROM Produs p");
        List<Produs> produse = (List<Produs>) query.getResultList();
        ArrayList<Produs> rez = new ArrayList<>();

        for (Produs p : produse) {
            for (String s : produsCod) {
                if (p.getCodBare().equals(s)) {
                    rez.add(p);
                }
            }
        }

        return rez;
    }

    public ProdusDetails findById(String produsCod) {
        
        Produs prod = em.find(Produs.class, produsCod);
        if(prod == null){
          return null;
        }
        return new ProdusDetails(prod.getCodBare(), prod.getDenumire(), prod.getPret());
    }

//    private List<CarDetails> copyCarsToDetails(List<Car> cars) {
//        List<CarDetails> detailsList = new ArrayList<>();
//        for (Car car : cars) {
//            CarDetails carDetails = new CarDetails(car.getId(),
//                    car.getLicensePlate(),
//                    car.getParkingSpot(),
//                    car.getUser().getUsername());
//            detailsList.add(carDetails);
//        }
//        return detailsList;
//    }
    public void createProduct(String barCode, String denumire, double pret) {
        LOG.info("createProdus");
        Produs produs = new Produs();
        produs.setCodBare(barCode);
        produs.setDenumire(denumire);
        produs.setPret(pret);

        em.persist(produs);
    }

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
