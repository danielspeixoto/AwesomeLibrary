package com.library.creator;

import com.library.model.User;
import com.library.presenter.Presenter;
import com.library.presenter.TeacherPresenter;
import com.library.repository.UserRepository;

public class PresenterCreator {

    private static PresenterCreator instance;
    private UserRepository userRepository;

    private PresenterCreator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static PresenterCreator getInstance() {
        if(instance == null) {
            instance = new PresenterCreator(UserRepository.getInstance());
        }
        return instance;
    }

    public Presenter getPresenter(int userId) {
        User user = userRepository.findById(userId);
        switch (user.getRole()) {
            case TEACHER:
                return new TeacherPresenter();
            case STUDENT:
                break;
            case EMPLOYEE:
                break;
        }
        return null;
    }
}
