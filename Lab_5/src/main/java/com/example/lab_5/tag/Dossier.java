package com.example.lab_5.tag;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;
import lombok.Setter;

import java.io.IOException;

@Setter
public class Dossier extends TagSupport {
    private String action;
    private String method;
    private String uri;

    @Override
    public int doAfterBody() throws JspException {
        var x = pageContext;
        return super.doAfterBody();
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            out.write("<form method=\""+ method +"\" action=\""+ uri + action + "\">");
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return EVAL_BODY_INCLUDE;
    }
    @Override
    public int doEndTag() {
        try {
            pageContext.getOut().write("</form> <br>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return EVAL_PAGE;
    }
}