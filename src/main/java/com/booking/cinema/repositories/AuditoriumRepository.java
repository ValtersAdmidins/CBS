<<<<<<< HEAD:src/main/java/com/booking/cinema/repositories/AuditoriumRepository.java
package com.booking.cinema.repositories;
=======
package com.booking.cinema.repository;
>>>>>>> valters3:src/main/java/com/booking/cinema/repository/AuditoriumRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.cinema.model.Auditorium;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {

}
