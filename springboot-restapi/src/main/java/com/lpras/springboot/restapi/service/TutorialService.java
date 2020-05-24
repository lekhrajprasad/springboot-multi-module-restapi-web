package com.lpras.springboot.restapi.service;


import com.lpras.lombok.model.Tutorial;

import java.util.List;
import java.util.Optional;

public interface TutorialService {
    /**
     * Method to create new employees in the db using mongo-db repository.
     *
     * @param tutorial
     */
    public Tutorial createTutorial(Tutorial tutorial);

    /**
     * Method to fetch all employees from the db using mongo-db repository.
     *
     * @return
     */
    public List<Tutorial> getAllTutorials(String title);

    /**
     * Method to fetch employee by id using mongo-db repository.
     *
     * @param id
     * @return
     */
    public Optional<Tutorial> getTutorialById(int id);

    public List<Tutorial> getTutorialsByPublished();

    /**
     * Method to delete employee by id using mongo-db repository.
     *
     * @param id
     */
    public void deleteTutorial(int id);

    /**
     * Method to update employee by id using mongo-db repository.
     *
     * @param id
     */
    public Tutorial updateTutorial(int id, Tutorial tutorial);


    /**
     * Method to delete all employees using mongo-db repository.
     */
    public void deleteAllTutorials();
}
