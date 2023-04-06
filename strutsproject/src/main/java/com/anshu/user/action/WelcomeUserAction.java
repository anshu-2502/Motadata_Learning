package com.anshu.user.action;

import com.opensymphony.xwork2.ActionSupport;

public class WelcomeUserAction extends ActionSupport
{
    private String uname,password;

    public String getUname ()
    {

        return uname;
    }

    public String getPassword ()
    {

        return password;
    }

    public void setUname (String uname)
    {

        this.uname = uname;
    }

    public void setPassword (String password)
    {

        this.password = password;
    }

    public String execute()
    {
        if(uname.equals("anshu") && password.equals("Anushk@01"))
        {
            return "SUCCESS";
        }
        else
        {
            return "ERROR";
        }
    }

}