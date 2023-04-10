package com.techelevator.dao;

import com.techelevator.model.UserInput;

public interface UserInputDao {

    UserInput addUserInput(UserInput incomingUserInput);

    boolean updateUserInput(UserInput updatedUserInput, int id);

    UserInput getUserInputByUserId(int userId);


}
