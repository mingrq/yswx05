package com.chiye.yswx05.ui.contactus;

import java.util.List;

public class ContactusEntity {
   private String ComanyName;
   private List<String> fourphonelist;
    private List<String> telephonelist;
    private List<String> faxlist;
    private List<String> websitelist;
    private String location;
    private List<String> emaillist;
    private List<String> qqlist;

    public String getComanyName() {
        return ComanyName;
    }

    public void setComanyName(String comanyName) {
        ComanyName = comanyName;
    }

    public List<String> getFourphonelist() {
        return fourphonelist;
    }

    public void setFourphonelist(List<String> fourphonelist) {
        this.fourphonelist = fourphonelist;
    }

    public List<String> getTelephonelist() {
        return telephonelist;
    }

    public void setTelephonelist(List<String> telephonelist) {
        this.telephonelist = telephonelist;
    }

    public List<String> getFaxlist() {
        return faxlist;
    }

    public void setFaxlist(List<String> faxlist) {
        this.faxlist = faxlist;
    }

    public List<String> getWebsitelist() {
        return websitelist;
    }

    public void setWebsitelist(List<String> websitelist) {
        this.websitelist = websitelist;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getEmaillist() {
        return emaillist;
    }

    public void setEmaillist(List<String> emaillist) {
        this.emaillist = emaillist;
    }

    public List<String> getQqlist() {
        return qqlist;
    }

    public void setQqlist(List<String> qqlist) {
        this.qqlist = qqlist;
    }
}
