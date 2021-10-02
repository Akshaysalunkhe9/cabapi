package com.codegram.cabapi.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegram.cabapi.domain.TripBooking;
import com.codegram.cabapi.exception.TripBookingIDException;
import com.codegram.cabapi.repository.TripBookingRepository;
import com.codegram.cabapi.service.TripBookingService;


/**
 * @author Arnav
 *
 */
@Service
public class TripBookingServiceImpl implements TripBookingService {
	@Autowired
	private TripBookingRepository tripBookingRepository;
	@PersistenceContext
	EntityManager em;

	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking) {
		// TODO Auto-generated method stub
		 tripBookingRepository.save(tripBooking);
		return tripBooking;
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) {
		// TODO Auto-generated method stub
		return tripBookingRepository.save(tripBooking);
	}

	@Override
	public Iterable<TripBooking> deleteTripBooking(int tripBookingId) {
		// TODO Auto-generated method stub
		tripBookingRepository.deleteById(tripBookingId);
		return tripBookingRepository.findAll();

	}

	@Override
	public Iterable<TripBooking> findAll() {
		// TODO Auto-generated method stub
		return tripBookingRepository.findAll();
	}

	@Override
	public List<TripBooking> viewAllTripsCustomer(int customerId) {
		// TODO Auto-generated method stub
		TypedQuery<TripBooking> q = em.createQuery("select tb from TripBooking tb where tb.customer.customerId=:customerId",TripBooking.class);
		q.setParameter("customerId", customerId);
		List<TripBooking> result = q.getResultList();
		return result;
	}

	@Override
	public float calculateBill(int customerId) {
		TypedQuery<TripBooking> q = em.createQuery("select tb from TripBooking tb where tb.customer.customerId=:customerId", TripBooking.class);
		q.setParameter("customerId", customerId);
		List<TripBooking> list = q.getResultList();
		Optional<Float> result = list.stream().map((tb) -> tb.getBill()).reduce((a,b) -> a+b);
		return result.get();
	}

	@Override
	public TripBooking viewTripById(int tripBookingId) {
		TripBooking tripBooking = tripBookingRepository.findBytripBookingId(tripBookingId);
		if(tripBooking == null)
			throw new TripBookingIDException("TripBooking ID :"+tripBookingId+" does not exist");
		return tripBooking;
	}

}
