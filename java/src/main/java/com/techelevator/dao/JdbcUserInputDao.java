package com.techelevator.dao;

import com.techelevator.model.UserInput;

public class JdbcUserInputDao implements UserInputDao{


    @Override
    public UserInput addUserInput(UserInput incomingUserInput) {
        return null;
    }

    @Override
    public boolean updateUserInput(UserInput updatedUserInput) {
        return false;
    }

    @Override
    public UserInput getUserInputByUserId(int userId) {
        return null;
    }
}
