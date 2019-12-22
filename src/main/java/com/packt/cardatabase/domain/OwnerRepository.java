/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.cardatabase.domain;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author tutm
 */

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    
}
