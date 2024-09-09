package org.springExamMVC.Service;

import org.springExamMVC.Exception.UserDataException;
import org.springExamMVC.dao.IVendor;
import org.springExamMVC.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Service
public class VendorService {
    @Autowired
    private IVendor vendorDao;

    public String ValidateVendor(UserModel um) throws UserDataException {
        String response = this.vendorDao.validateVendor(um.getName(), um.getPassword(), um.getRole());
        return response;
    }


}
