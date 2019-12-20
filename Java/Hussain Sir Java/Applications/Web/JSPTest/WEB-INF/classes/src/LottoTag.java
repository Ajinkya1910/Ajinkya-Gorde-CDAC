package basic.web.app;

import java.io.*;
import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class LottoTag extends SimpleTagSupport{

	private int digits = 8;
	private String variable;
	private static Random rdm = new Random();

	public void setDigits(int value){
		digits = value;
	}

	public void setVariable(String name){
		variable = name;
	}

	@Override
	public void doTag() throws IOException, JspException{
		JspContext context = super.getJspContext();
		JspFragment body = super.getJspBody();
		for(int i = 0; i < digits; ++i){
			int value = rdm.nextInt(10);
			context.setAttribute(variable, value);
			body.invoke(null);
		}
	}


}

