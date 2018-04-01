package com.kaipai.ck.common;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kaipai.base.res.AiwResult;
import com.kaipai.ck.message.MessageCode;

public class KpExceptionHandler implements HandlerExceptionResolver {
	
	protected final transient Logger log = Logger.getLogger(KpExceptionHandler.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest req,
			HttpServletResponse res, Object handler, Exception ex) {
		
		PrintWriter out = null;
		try {
			ex.printStackTrace();
			
			out = res.getWriter();
			res.setCharacterEncoding("UTF-8");
			res.setContentType("application/json,charset='UTF-8'");
			res.setHeader("Cache-Control", "no-store");//or no-cache
			res.setHeader("Pragrma", "no-cache"); 
			res.setDateHeader("Expires", 0);
			out.write(new Gson().toJson(new AiwResult(MessageCode.FAIL)));
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.flush();
			out.close();
		}
		return null;
	}

}
