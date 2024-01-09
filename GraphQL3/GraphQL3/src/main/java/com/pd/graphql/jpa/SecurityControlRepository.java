package com.pd.graphql.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityControlRepository extends JpaRepository<SecurityControl, SecurityControlPK> {

	public List<SecurityControl> findByCag(String cagString);
}
