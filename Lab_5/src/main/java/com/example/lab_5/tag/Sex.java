package com.example.lab_5.tag;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;

public class Sex extends TagSupport {
    @Override
    public int doAfterBody() throws JspException {
        try {
            pageContext.getOut().write("<h1>body</h1>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return super.doAfterBody();
    }

    @Override
    public int doStartTag() throws JspException {

        try {
            JspWriter out = pageContext.getOut();
            out.write("<label>Male");
            out.write("<input type='radio' id='contactChoice1' name='sex' value='male'>");
            out.write("</label>");
            out.write("<label>Female");
            out.write("<input type='radio' id='contactChoice1' name='sex' value='female'>");
            out.write("</label> <br>");
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return EVAL_BODY_INCLUDE;
    }
    @Override
    public int doEndTag() {
        return EVAL_PAGE;
    }
}