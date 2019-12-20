package basic.web.app;

import java.io.*;
import java.util.*;
import java.text.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class ClockTag implements SimpleTag{

	private JspContext context;
	private JspFragment body;
	private JspTag parent;

	private SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

	public void setJspContext(JspContext value){context = value;}

	public void setJspBody(JspFragment value){body = value;}

	public void setParent(JspTag value){parent = value;}

	public JspTag getParent(){return parent;}

	public void doTag() throws IOException, JspException{
		JspWriter out = context.getOut();
		Date now = new Date();
		String markup = String.format("<span>%s</span>", formatter.format(now));
		out.print(markup);
	}

	public void setFormat(String value){
		formatter.applyPattern(value);
	}
}


