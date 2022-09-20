package com.example.lab_5.tag;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

import java.io.IOException;

public class Surname extends TagSupport {

    @Override
    public int doStartTag() throws JspException {

        try{
            JspWriter out = pageContext.getOut();
            out.write("<label>Surname ");
            out.write("<input type='text' name='surname'>");
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
