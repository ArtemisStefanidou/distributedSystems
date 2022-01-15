package org.hua.dit.distributedsystems.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hua.dit.distributedsystems.models.Subject;
import org.hua.dit.distributedsystems.repositories.SubjectRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class QuestionServiceImpl implements QuestionService{

    private final SubjectRepo subjectRepo;

    @Override
    public Subject saveSubject(Subject subject) {
        return subjectRepo.save(subject);
    }

}
