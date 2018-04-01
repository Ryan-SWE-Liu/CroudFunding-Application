package com.kaipai.ck.aliy;

import java.util.HashMap;
import java.util.Map;

import com.kaipai.base.alipay.AlipayConfig;
import com.kaipai.ck.model.CallBackModel;
/**
 * 支付宝统一收单线下交易预创建参数
 * @author cloud
 *
 */
public class AlipayPrecreateOrder extends CallBackModel{

	private static final long serialVersionUID = -2247552240645215996L;
	
	/** 商户合作ID **/
	private String app_id;
	/** 接口名称 **/
	private String method;
	/** 编码格式 **/
	private String charset;
	/** 签名 **/
	private String sign;
	/** 签名类型 **/
	private String sign_type;
	/** 发送请求的时间，格式"yyyy-MM-dd HH:mm:ss" **/
	private String timestamp;
	/** 调用的接口版本，固定为：1.0 **/
	private String version;
	/** 回调接口 **/
	private String notify_url;
	
	/** 商户订单号,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复 **/
	private String out_trade_no;
	
	/** 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000] 如果同时传入了【打折金额】，
	【不可打折金额】，【订单总金额】三者，则必须满足如下条件：【订单总金额】=【打折金额】+【不可打折金额】**/
	private String total_amount;
	
	/** 订单标题 **/
	private String subject;
	/** 对交易或商品的描述 **/
	private String body;//支付状态

	/**  当前预下单请求生成的二维码码串，可以用二维码生成工具根据该码串值生成对应的二维码 **/
	private String qr_code ;
	
	private String trade_no;//订单号
	private String content;//回调内容
	
	
	public Map<String,String> getReqMap(){
		Map<String,String> result = new HashMap<String,String>();
		result.put("app_id", AlipayConfig.app_id);
		result.put("method", AlipayConfig.trade_precreate_method);
		result.put("charset", AlipayConfig.input_charset);
		result.put("sign_type", AlipayConfig.sign_type);
		//result.put("notify_url", AlipayConfig.notify_url);
		result.put("sign", getSign());
		result.put("trade_no", getTrade_no());
		result.put("timestamp", getTimestamp());
		result.put("subject", getSubject());
		result.put("version", AlipayConfig.version);
		result.put("out_trade_no", getOut_trade_no());
		result.put("total_amount", getTotal_amount());
		result.put("subject",getSubject());
		result.put("body",getBody());
		
		return result;
	}
	
	public Map<String,String> getResMap(){
		Map<String,String> result = new HashMap<String,String>();
		result.put("trade_no",getTrade_no());
		result.put("out_trade_no",getOut_trade_no());
		result.put("qr_code",getQr_code());
		return result;
	}

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getQr_code() {
		return qr_code;
	}

	public void setQr_code(String qr_code) {
		this.qr_code = qr_code;
	}

	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	
	
}
