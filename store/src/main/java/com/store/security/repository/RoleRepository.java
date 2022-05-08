package com.store.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.store.security.entity.Role;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long>{

	
	/**
	 * Gets role by name.
	 * @param name
	 * @return
	 */
	@Query(value = "SELECT r FROM Role r WHERE r.name = :name")
	Role getByName(@RequestParam("name") String name);
}
