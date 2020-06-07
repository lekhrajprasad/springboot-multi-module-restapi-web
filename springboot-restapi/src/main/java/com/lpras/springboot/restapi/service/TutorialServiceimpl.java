package com.lpras.springboot.restapi.service;


import com.lpras.lombok.model.Tutorial;
import com.lpras.springboot.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TutorialServiceimpl implements TutorialService {

    @Autowired
    private TutorialRepository tutorialRepository;


    @Override
    public Tutorial createTutorial(Tutorial tut) {
        return tutorialRepository.save(new Tutorial(null, tut.getTitle(), tut.getDescription(), false));
    }


    @Override
    public List<Tutorial> getAllTutorials(String title) {
        List<Tutorial> tutorials = new ArrayList<>();
        if (title == null)
            tutorialRepository.findAll().forEach(tutorials::add);
        else
            tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);
        return tutorials;
    }

    @Override
    public Optional<Tutorial> getTutorialById(int id) {
        return tutorialRepository.findById(id);
    }

    @Override
    public List<Tutorial> getTutorialsByPublished() {
        return tutorialRepository.findByPublished(true);
    }

    @Override
    public void deleteTutorial(int id) {
        tutorialRepository.deleteById(id);
    }

    @Override
    public Tutorial updateTutorial(int id, Tutorial tutorial) {
        Optional<Tutorial> tutorialDataFromRepo = tutorialRepository.findById(id);
        if (tutorialDataFromRepo.isPresent()) {
            Tutorial tutorialData = tutorialDataFromRepo.get();
            tutorialData.setTitle(tutorial.getTitle());
            tutorialData.setDescription(tutorial.getDescription());
            tutorialData.setPublished(tutorial.isPublished());
            return tutorialRepository.save(tutorialData);
        } else {
            return null;
        }
    }

    @Override
    public void deleteAllTutorials() {
        tutorialRepository.deleteAll();
    }

}
