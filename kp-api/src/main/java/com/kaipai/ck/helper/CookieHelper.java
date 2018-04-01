package com.kaipai.ck.helper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kaipai.utils.Md5Utils;


public class CookieHelper {

	protected static final transient Logger log = Logger.getLogger("security");
	/**
	 * 像cookie中添加指定name和value
	 * 
	 * @param response
	 * @param name
	 * @param value
	 */
	public static void addValueToCookie(HttpServletResponse response,
			String name, String value) {
		if (response != null && StringUtils.isNotBlank(name)) {
			Cookie cookie = new Cookie(name, value);
			cookie.setPath("/");
			cookie.setMaxAge(60 * 60 * 24 * 7);
			response.addCookie(cookie);
		}
	}
	
	 /**
     * 获取cookie的值
     * @param req
     * @param name
     * @return
     */
    public static String getName(HttpServletRequest req,String name) {
        Cookie cookie = get(req,name);
        log.debug("===req cookie name:"+name+"=======cookie value:"+cookie);
        String cookieVal = (null == cookie) ? null : cookie.getValue();
        return cookieVal;
    }
    public static Cookie get(HttpServletRequest req,String name) {
        Map<String,Cookie> cookieMap = _readCookieMap(req);
        if(cookieMap.containsKey(name)) {
            return (Cookie)cookieMap.get(name);
        } else {
            return null;
        }
    }
    private static Map<String,Cookie> _readCookieMap(HttpServletRequest req) {
        Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
        Cookie[] cookies = req.getCookies();
        if(null != cookies) {
            for(Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(),cookie);
            }
        }
        return cookieMap;
    }
  
    /**
     * 移除cookie
     * @param req
     * @param response
     * @param name
     */
	public static void removeCookie(HttpServletRequest req,HttpServletResponse response,
			String name) {
		   String cookieName = getName(req,name);
		   log.debug("===req cookieName name:"+cookieName);
	        if(null != cookieName) {
	            Cookie cookie = new Cookie(name,null);
	            cookie.setMaxAge(0);
	            cookie.setPath("/");
	            response.addCookie(cookie);
	        }
	}


	public static Cookie getCookie(HttpServletRequest request, String name) {
		Cookie cookie = null;
		if (request == null || StringUtils.isBlank(name)) {
			return cookie;
		}
		for (Cookie c : request.getCookies()) {
			if (c.getName().equals(name)) {
				cookie = c;
			}
		}
		return cookie;
	}

	// 生成一个ticket
	public static String GenerateTicket(String userId, String empCode) {
		return Md5Utils.getMD5(userId + empCode + new Date().getTime());
	}

}
