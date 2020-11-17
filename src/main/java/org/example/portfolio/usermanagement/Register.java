package org.example.portfolio.usermanagement;

import com.opensymphony.xwork2.ActionSupport;
import org.example.portfolio.usermanagement.entities.User;

public class Register extends ActionSupport {

    private String userName;
    private String password;
    private String portfolioName;

    @Override
    public void validate() {
        if (getPassword().length() == 0) {
            addFieldError("userName",getText("password.required"));
        }
        if (getUserName().length() == 0) {
            addFieldError("userName",getText("username.required"));
        }
        if (getPortfolioName().length() == 0) {
            addFieldError("portfolioName",getText("portfolioName.required"));
        }
    }

    @Override
    public String execute() throws Exception {
        User user = new User();
        user.setPassword(getPassword());
        user.setPortfolioName(getPortfolioName());

        return SUCCESS;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }
}
