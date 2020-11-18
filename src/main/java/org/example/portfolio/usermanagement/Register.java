package org.example.portfolio.usermanagement;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.example.portfolio.usermanagement.entities.User;
import org.example.portfolio.usermanagement.services.PortfolioService;

public class Register extends ActionSupport implements ModelDriven<User> {

    private User user = new User();


    @Override

    public void validate() {
        if (user.getPassword().length() == 0) {
            addFieldError("username", getText("password.required"));
        }
        if (user.getUsername().length() == 0) {
            addFieldError("password", getText("username.required"));
        }
        if (user.getPortfolioName().length() == 0) {
            addFieldError("portfolioName", getText("portfolioName.required"));
        }
        if (getPortfolioService().userExists(user.getUsername())) {
            addFieldError("username", "user.exists");
        }
    }

    @Override
    public String execute() throws Exception {
        getPortfolioService().createAccount(user);
        return SUCCESS;
    }


    public PortfolioService getPortfolioService() {
        return new PortfolioService();
    }

    @Override
    public User getModel() {
        return user;
    }
}
