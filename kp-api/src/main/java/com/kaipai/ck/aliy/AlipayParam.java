package com.kaipai.ck.aliy;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.wordnik.swagger.annotations.ApiModelProperty;
import com.kaipai.base.alipay.AlipayConfig;
import com.kaipai.ck.constant.CommonConstant.AppType;
import com.kaipai.ck.model.CallBackModel;
import com.kaipai.ck.model.common.RequestHeadersModel;
import com.kaipai.ck.utils.CommentUtils;

/**
 * 支付宝参数
 * @author cloud
 *
 */
public class AlipayParam extends CallBackModel{

	private static final long serialVersionUID = -2247552240645215996L;
	@ApiModelProperty(value="商户合作ID")
	private String parent;//商户合作ID
	@ApiModelProperty(value="卖家ID")
	private String seller_email;//卖家邮箱
	@ApiModelProperty(value="回调接口")
	private String notify_url;//回调接口
	private String sign;//签名
	private String sign_type;//签名类型
	private String out_trade;//
	private String price;//单价
	private String subject;//标题
	private String quantity;//数量
	private String payment_type;//支付状态
	private String logistics_type;//快递类型
	private String discount;//是否打折
	private String buyer_email;//买家邮箱
	private String gmt_create;//创建时间
	private String gmt_close;//创建时间
	private String gmt_payment;//创建时间
	private String seller_id;//卖家ID
	private String notify_time;//通知时间
	private String body;//
	private String trade_status;//交易状态
	private String is_total_fee_adjust;//
	private String total_fee;//总金额
	private String buyer_id;//买家ID
	private String notify_id;//通知ID
	private String use_coupon;//是否使用优惠券
	private String notify_type;//通知类型
	@ApiModelProperty(value="订单号")
	private String trade_no;//订单号
	private String out_trade_no;//订单号
	private String content;//回调内容
	
	public AlipayParam(){
		this.parent = AlipayConfig.partner;
		this.seller_email = AlipayConfig.seller_mail;
		this.notify_url = AlipayConfig.notify_url;
	}
	
	public AlipayParam(HttpServletRequest request){
		RequestHeadersModel headers = CommentUtils.getHeaders(request);
		if(AppType.TYPE_XF.equals(headers.getAppType())){
			this.parent = AlipayConfig.xf_app_key;
		}else{
			this.parent = AlipayConfig.partner;
		}
		this.seller_email = AlipayConfig.seller_mail;
		this.notify_url = AlipayConfig.notify_url;
	}
	
	public Map<String,String> getReqMap(){
		Map<String,String> result = new HashMap<String,String>();
		result.put("key", AlipayConfig.ali_private_key);
		result.put("partner", AlipayConfig.partner);
		result.put("seller_email", AlipayConfig.seller_mail);
		result.put("input_charset", AlipayConfig.input_charset);
		result.put("sign_type", AlipayConfig.sign_type);
		result.put("notify_url", AlipayConfig.notify_url);
		result.put("out_trade", getOut_trade());
		result.put("trade_no", getTrade_no());
		result.put("price", getPrice());
		result.put("subject", getSubject());
		result.put("quantity", getQuantity());
		result.put("payment_type", getPayment_type());
		result.put("logistics_type", getLogistics_type());
		result.put("out_trade_no",getOut_trade_no());
		
		return result;
	}
	
	public Map<String,String> getResMap(){
		Map<String,String> result = new HashMap<String,String>();
		result.put("trade_no",getTrade_no());
		result.put("discount",getDiscount());
		result.put("payment_type",getPayment_type());
		result.put("subject",getSubject());
		result.put("trade_status",getTrade_status());
		result.put("buyer_email",getBuyer_email());
		result.put("gmt_create",getGmt_create());
		result.put("gmt_payment",getGmt_payment());
		result.put("gmt_close",getGmt_create());
		result.put("notify_type",getNotify_type());
		result.put("quantity",getQuantity());
		result.put("out_trade_no",getOut_trade_no());
		result.put("seller_id",getSeller_id());
		result.put("notify_time",getNotify_time());
		result.put("body",getBody());
		result.put("trade_status",getTrade_status());
		result.put("is_total_fee_adjust",getIs_total_fee_adjust());
		result.put("total_fee",getTotal_fee());
		result.put("seller_email",AlipayConfig.seller_mail);
		result.put("price",getPrice());
		result.put("buyer_id",getBuyer_id());
		result.put("notify_id",getNotify_id());
		result.put("use_coupon",getUse_coupon());
		result.put("sign_type",getSign_type());
		result.put("sign",getSign());
		return result;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getSeller_email() {
		return seller_email;
	}

	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
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

	public String getOut_trade() {
		return out_trade;
	}

	public void setOut_trade(String out_trade) {
		this.out_trade = out_trade;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public String getLogistics_type() {
		return logistics_type;
	}

	public void setLogistics_type(String logistics_type) {
		this.logistics_type = logistics_type;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getBuyer_email() {
		return buyer_email;
	}

	public void setBuyer_email(String buyer_email) {
		this.buyer_email = buyer_email;
	}

	public String getGmt_create() {
		return gmt_create;
	}

	public void setGmt_create(String gmt_create) {
		this.gmt_create = gmt_create;
	}

	public String getGmt_close() {
		return gmt_close;
	}

	public void setGmt_close(String gmt_close) {
		this.gmt_close = gmt_close;
	}

	public String getGmt_payment() {
		return gmt_payment;
	}

	public void setGmt_payment(String gmt_payment) {
		this.gmt_payment = gmt_payment;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public String getNotify_time() {
		return notify_time;
	}

	public void setNotify_time(String notify_time) {
		this.notify_time = notify_time;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTrade_status() {
		return trade_status;
	}

	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}

	public String getIs_total_fee_adjust() {
		return is_total_fee_adjust;
	}

	public void setIs_total_fee_adjust(String is_total_fee_adjust) {
		this.is_total_fee_adjust = is_total_fee_adjust;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}

	public String getNotify_id() {
		return notify_id;
	}

	public void setNotify_id(String notify_id) {
		this.notify_id = notify_id;
	}

	public String getUse_coupon() {
		return use_coupon;
	}

	public void setUse_coupon(String use_coupon) {
		this.use_coupon = use_coupon;
	}

	public String getNotify_type() {
		return notify_type;
	}

	public void setNotify_type(String notify_type) {
		this.notify_type = notify_type;
	}

	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
