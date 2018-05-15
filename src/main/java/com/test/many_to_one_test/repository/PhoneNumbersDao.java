package com.test.many_to_one_test.repository;

import com.test.many_to_one_test.domain.PhoneNumbers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumbersDao extends JpaRepository<PhoneNumbers, Integer> {
}
