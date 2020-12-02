package org.example.portfolio.usermanagement;

import com.opensymphony.xwork2.ActionSupport;
import org.example.portfolio.usermanagement.services.PortfolioService;

import java.io.File;

public class ImageUpload  extends ActionSupport {

    private File pic;
    private String picContentType;
    private String picFileName;

    @Override
    public String execute() throws Exception {
        getProFileService().addImage(getPic());
        return SUCCESS;
    }

    private PortfolioService getProFileService() {
        return new PortfolioService();
    }

    public String getPicContentType() {
        return picContentType;
    }

    public void setPicContentType(String picContentType) {
        this.picContentType = picContentType;
    }

    public String getPicFileName() {
        return picFileName;
    }

    public void setPicFileName(String picFileName) {
        this.picFileName = picFileName;
    }

    public File getPic() {
        return pic;
    }

    public void setPic(File pic) {
        this.pic = pic;
    }
}
