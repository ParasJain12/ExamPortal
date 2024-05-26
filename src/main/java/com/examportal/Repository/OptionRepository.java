package com.examportal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.examportal.Model.Option;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {

}
