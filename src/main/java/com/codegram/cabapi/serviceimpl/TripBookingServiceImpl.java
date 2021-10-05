package com.codegram.cabapi.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegram.cabapi.domain.Cab;
import com.codegram.cabapi.domain.Customer;
import com.codegram.cabapi.domain.Driver;
import com.codegram.cabapi.domain.TripBooking;
import com.codegram.cabapi.exception.TripBookingIDException;
import com.codegram.cabapi.repository.CabRepository;
import com.codegram.cabapi.repository.CustomerRepository;
import com.codegram.cabapi.repository.DriverRepository;
import com.codegram.cabapi.repository.TripBookingRepository;
import com.codegram.cabapi.service.TripBookingService;

/**
 * This  TripBookingServiceImplementation  will implement all the methods from the TripBookingService Interface
 * @author Arnav
 *
 */
@Service
public class TripBookingServiceImpl implements TripBookingService {
	@Autowired
	private TripBookingRepository tripBookingRepository;
	@Autowired
	private CabRepository cabRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private DriverRepository driverRepository;
	@PersistenceContext
	EntityManager em;

	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking, int customerId, int cabId, int driverId) {
		try {
			Customer customer = customerRepository.findById(customerId);
			Cab cab = cabRepository.findById(cabId);
			Driver driver = driverRepository.findById(driverId);
			tripBooking.setCustomer(customer);
			tripBooking.setCab(cab);
			tripBooking.setDriver(driver);
			tripBooking.setBill( tripBooking.getDistanceInKm() * cab.getPerKmRate());
			tripBookingRepository.save(tripBooking);
			return tripBooking;
		}
		catch (Exception e) {
			throw new TripBookingIDException("Customer Id :"+customerId+" does not exist.");
		}
		 
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) {
		return tripBookingRepository.save(tripBooking);
	}

	@Override
	public void deleteTripBooking(int tripBookingId) {
		try {
			TripBooking tripBooking = tripBookingRepository.findById(tripBookingId);
			if(tripBooking == null)
				throw new TripBookingIDException("TripBooking ID :"+tripBookingId+" does not exist");
			tripBookingRepository.delete(tripBooking);
		}
		catch (Exception e) {
			throw new TripBookingIDException("TripBooking ID :"+tripBookingId+" does not exist");
		}
		
	}

	@Override
	public Iterable<TripBooking> findAll() {
		return tripBookingRepository.findAll();
	}

	@Override
	public List<TripBooking> viewAllTripsCustomer(int customerId) {
		TypedQuery<TripBooking> q = em.createQuery("select tb from TripBooking tb where tb.customer.id=:customerId",TripBooking.class);
		q.setParameter("id", customerId);
		List<TripBooking> result = q.getResultList();
		return result;
	}

	@Override
	public float calculateTotalBill(int customerId) {
		TypedQuery<TripBooking> q = em.createQuery("select tb from TripBooking tb where tb.customer.id=:customerId", TripBooking.class);
		q.setParameter("id", customerId);
		List<TripBooking> list = q.getResultList();
		Optional<Float> result = list.stream().map((tb) -> tb.getBill()).reduce((a,b) -> a+b);
		return result.get();
	}

	@Override
	public TripBooking viewTripById(int tripBookingId) {
		TripBooking tripBooking = tripBookingRepository.findById(tripBookingId);
		if(tripBooking == null)
			throw new TripBookingIDException("TripBooking ID :"+tripBookingId+" does not exist");
		return tripBooking;
	}

}