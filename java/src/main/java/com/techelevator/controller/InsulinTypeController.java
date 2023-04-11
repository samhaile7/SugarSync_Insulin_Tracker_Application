package com.techelevator.controller;


import com.techelevator.dao.InsulinTypeDao;
import com.techelevator.model.InsulinType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
@RestController
@CrossOrigin

public class InsulinTypeController {

    private InsulinTypeDao insulinTypeDao;

    public InsulinTypeController(InsulinTypeDao insulinTypeDao) {
        this.insulinTypeDao = insulinTypeDao;
    }

    @RequestMapping(path = "/allinsulintypes", method = RequestMethod.GET)
    public List<InsulinType> getAllInsulinTypes() {
        return insulinTypeDao.getAllInsulinTypes();
    }
    
}
