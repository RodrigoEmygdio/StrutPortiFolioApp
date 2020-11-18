package org.example.portfolio.usermanagement;

import com.opensymphony.xwork2.ActionSupport;
import org.example.portfolio.usermanagement.entities.User;
import org.example.portfolio.usermanagement.services.PortfolioService;

public class Register extends ActionSupport {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override

    public void validate() {
        if (getUser().getPassword().length() == 0) {
            addFieldError("user.username", getText("password.required"));
        }
        if (getUser().getUsername().length() == 0) {
            addFieldError("user.password", getText("username.required"));
        }
        if (getUser().getPortfolioName().length() == 0) {
            addFieldError("user.portfolioName", getText("portfolioName.required"));
        }
        if (getPortfolioService().userExists(user.getUsername())) {
            addFieldError("user.username", "user.exists");
        }
    }

    @Override
    public String execute() throws Exception {
        getPortfolioService().createAccount(getUser());
        return SUCCESS;
    }


    public PortfolioService getPortfolioService() {
        return new PortfolioService();
    }
}
