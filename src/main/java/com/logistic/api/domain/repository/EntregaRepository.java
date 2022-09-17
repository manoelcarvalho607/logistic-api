/**
 * 
 */
package com.logistic.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logistic.api.domain.model.Entrega;

/**
 * @author manoel.carvalho
 *
 */

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {

}
