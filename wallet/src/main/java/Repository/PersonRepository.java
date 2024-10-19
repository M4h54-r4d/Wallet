package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Entitiy.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	}