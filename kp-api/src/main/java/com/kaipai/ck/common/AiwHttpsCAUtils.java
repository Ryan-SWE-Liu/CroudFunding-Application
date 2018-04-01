package com.kaipai.ck.common;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.util.Properties;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.kaipai.ck.wx.configs.WxConfigs;

@SuppressWarnings("deprecation")
public class AiwHttpsCAUtils {
	protected final transient static Logger log = Logger.getLogger(AiwHttpsCAUtils.class);
	
	private static final String CHARSET = "UTF-8";
	//private static final String HTTP_POST = "POST";
	//private static final String HTTP_GET = "GET";

	/**
	 * post方法
	 * @param url  微信接口url
	 * @param data xml格式
	 * @return
	 */
	static public String doHttpsPost(String url, String data) {
            
		String result = null;
		try {
			String path = Thread.currentThread().getContextClassLoader().getResource("/").getPath();
			Properties props=System.getProperties(); //获得系统属性集    
			String osName = props.getProperty("os.name"); //操作系统名称 
			log.info("---------------------系统osName："+osName); 
			char oneChar = path.charAt(0);
			char twoChar = path.charAt(1);
			if (osName.startsWith("Win")) {
				if (oneChar=='/') {
					path = path.replaceFirst("/", "");
				}
			}else {
				if (twoChar=='/') {
					path = path.replaceFirst("/", "");
				}
					
			}
			path = path+WxConfigs.WxPay.WX_APICLIENT_CERT;
			log.info("---------------------路径："+path);
			KeyStore keyStore  = KeyStore.getInstance("PKCS12");
			File file = new File(path);
			log.info("---------------------密钥名称："+file.getName());
	        FileInputStream instream = new FileInputStream(file);
			log.info("---------------------instream："+instream);
	        try {
	            keyStore.load(instream, WxConfigs.WxPay.MCH_ID.toCharArray());
	        } finally {
	            instream.close();
	        }
	        // Trust own CA and all self-signed certs
	        SSLContext sslcontext = SSLContexts.custom()
	                .loadKeyMaterial(keyStore, WxConfigs.WxPay.MCH_ID.toCharArray())
	                .build();
	        // Allow TLSv1 protocol only
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
	                sslcontext,
	                new String[] { "TLSv1" },
	                null,
	                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
	        CloseableHttpClient httpclient = HttpClients.custom()
	                .setSSLSocketFactory(sslsf)
	                .build();
	        try {

	            HttpPost httpPost = new HttpPost(url);
	            log.info("executing request" + httpPost.getRequestLine());
	            httpPost.setEntity(new StringEntity(data, CHARSET));
	            CloseableHttpResponse response = httpclient.execute(httpPost);
	            try {
	                HttpEntity entity = response.getEntity();

	                log.info("----------------------------------------"+response.getStatusLine());
	                if (entity != null) {
	                    System.out.println("Response content length: " + entity.getContentLength());
	                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()));
	                    log.info("==========返回的数据："+bufferedReader);
	                    String text;
	                    while ((text = bufferedReader.readLine()) != null) {
	                        System.out.println(text);
	       				 //连接成一个字符串 
		       					if (result != null)
		       						result += text;
		       					else
		       						result = text;
		                    }
	                   
	                }
	                EntityUtils.consume(entity);
	            }catch (Exception e) {
	                log.debug(" redPack***3****AiwHttpsCAUtils fail:"+e.getMessage());
	            } finally {
	                response.close();
	            }
	        }catch (Exception e) {
	            log.debug(" redPack***2****AiwHttpsCAUtils fail:"+e.getMessage());
	        } finally {
	            httpclient.close();
	        }
		} catch (Exception e) {
            log.debug(" redPack***1****AiwHttpsCAUtils fail:"+e.getMessage());
		}
		return result;
		
	}
		
	/**
	 * get方法
	 * @param url  微信接口url
	 * @param data xml格式
	 * @return
	 */
	static public String doHttpsGet(String url, String data) {
            
		String result = null;
		try {
			String path = Thread.currentThread().getContextClassLoader().getResource("/").getPath();
			Properties props=System.getProperties(); //获得系统属性集    
			String osName = props.getProperty("os.name"); //操作系统名称 
			log.info("---------------------系统osName："+osName); 
			char oneChar = path.charAt(0);
			char twoChar = path.charAt(1);
			if (osName.startsWith("Win")) {
				if (oneChar=='/') {
					path = path.replaceFirst("/", "");
				}
			}else {
				if (twoChar=='/') {
					path = path.replaceFirst("/", "");
				}
					
			}
			path = path+WxConfigs.WxPay.WX_APICLIENT_CERT;
			log.info("---------------------路径："+path);
			KeyStore keyStore  = KeyStore.getInstance("PKCS12");
			File file = new File(path);
			log.info("---------------------密钥名称："+file.getName());
	        FileInputStream instream = new FileInputStream(file);
			log.info("---------------------instream："+instream);
	        try {
	            keyStore.load(instream, WxConfigs.WxPay.MCH_ID.toCharArray());
	        } finally {
	            instream.close();
	        }
	        // Trust own CA and all self-signed certs
	        SSLContext sslcontext = SSLContexts.custom()
	                .loadKeyMaterial(keyStore, WxConfigs.WxPay.MCH_ID.toCharArray())
	                .build();
	        // Allow TLSv1 protocol only
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
	                sslcontext,
	                new String[] { "TLSv1" },
	                null,
	                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
	        CloseableHttpClient httpclient = HttpClients.custom()
	                .setSSLSocketFactory(sslsf)
	                .build();
	        try {

	            HttpGet httpGet = new HttpGet(url);
	            log.info("executing request" + httpGet.getRequestLine());
	            ((HttpResponse) httpGet).setEntity(new StringEntity(data, CHARSET));
	            CloseableHttpResponse response = httpclient.execute(httpGet);
	            try {
	                HttpEntity entity = response.getEntity();

	                log.info("----------------------------------------"+response.getStatusLine());
	                if (entity != null) {
	                    System.out.println("Response content length: " + entity.getContentLength());
	                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()));
	                    log.info("==========返回的数据："+bufferedReader);
	                    String text;
	                    while ((text = bufferedReader.readLine()) != null) {
	                        System.out.println(text);
	       				 //连接成一个字符串 
		       					if (result != null)
		       						result += text;
		       					else
		       						result = text;
		                    }
	                   
	                }
	                EntityUtils.consume(entity);
	            }catch (Exception e) {
	                log.debug(" redPack***3****AiwHttpsCAUtils fail:"+e.getMessage());
	            } finally {
	                response.close();
	            }
	        }catch (Exception e) {
	            log.debug(" redPack***2****AiwHttpsCAUtils fail:"+e.getMessage());
	        } finally {
	            httpclient.close();
	        }
		} catch (Exception e) {
            log.debug(" redPack***1****AiwHttpsCAUtils fail:"+e.getMessage());
		}
		return result;
		
	}
		
		
}
