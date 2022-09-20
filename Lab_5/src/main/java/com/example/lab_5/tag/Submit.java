package com.example.lab_5.tag;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

import java.io.IOException;

public class Submit extends TagSupport {

    @Override
    public int doStartTag() throws JspException {

        try{
            JspWriter out = pageContext.getOut();
            out.write("<label>");
            out.write("<input type='submit' value='ok'>");
            out.write("<input type='button' value='cancel'>");
            out.write("</label> <br>");
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return  SKIP_BODY;
    }

    @Override
    public int doEndTag() {
        return EVAL_PAGE;
    }
}
