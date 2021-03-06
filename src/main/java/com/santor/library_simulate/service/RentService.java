package com.santor.library_simulate.service;

import com.santor.library_simulate.dto.RentDTO;

import java.util.List;

public interface RentService {

    /**
     * Get all rents
     * @return List<RentDTO>
     */
    List<RentDTO> getAll();

    /**
     * Get a rent by id
     * @param id -
     * @return RentDTO
     */
    RentDTO getById(Long id);

    /**
     * Delete all rents
     */
    void deleteAll();

    /**
     * Delete a rent by id
     * @param id -
     */
    void deleteById(Long id);

    /**
     * Update a rent
     * @param rent -
     */
    void update(RentDTO rent);

    /**
     * Add a rent
     * @param rent -
     */
    void add(RentDTO rent);

}
