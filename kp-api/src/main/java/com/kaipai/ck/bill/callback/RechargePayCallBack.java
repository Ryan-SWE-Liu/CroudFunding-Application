package com.kaipai.ck.bill.callback;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.util.StringUtils;

import com.kaipai.ck.constant.KpContants;
import com.kaipai.ck.constant.CommonConstant.SourceType;
import com.kaipai.ck.constant.KpContants.TRADE;
import com.kaipai.ck.model.order.OrderModel;
import com.kaipai.ck.service.trade.TradeInfoService;
import com.kaipai.ck.service.wx.WxPayService;
import com.kaipai.redis.ICache;
import com.kaipai.redis.jredis.RedisClusterCacheImp;
import com.kaipai.utils.AiwHttpUtils;
import com.kaipai.utils.SpringUtils;
import com.kaipai.xf.interfaces.stock.IStockAgentService;
import com.kaipai.xf.model.display.StockBaseInfoModel;

public class RechargePayCallBack extends AbstractPayCallBack{
    /**
     * 
     * 充值成功后逻辑
     *  
     * */
	@Override
	protected void execute(OrderModel orderModel) {
		
    	ICache cache = RedisClusterCacheImp.getInstance();
    	
    	//同步交易
    	String data = cache.get(KpContants.ORDER.PAY_TYPE_COLL_MV+orderModel.getOrderNo());
    	log.info("======data============"+data);
    	if (!StringUtils.isEmpty(data)) {
    		JSONObject jsonObject = JSONObject.fromObject(data);
    		String collNo = jsonObject.getString("collNo");
    		String num = jsonObject.getString("num");
    		
			IStockAgentService stockAgentService = SpringUtils.getBean("stockAgentService", IStockAgentService.class);
			TradeInfoService tradeInfoService = SpringUtils.getBean("tradeInfoService",TradeInfoService.class);
			String stockCode = tradeInfoService.getStockCodeByCollNo(collNo);
			StockBaseInfoModel sInfoModel = stockAgentService.getStockeInfo(stockCode);
			double price = sInfoModel.getPreClose()*1.1;

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("stockCode", stockCode);
			map.put("orderType", "WT_BUY");
			map.put("userId", orderModel.getUserId());
			map.put("opNum", num);
			map.put("opAmt", price);
		    String xmlStr = WxPayService.createLinkString(map);
		    log.info("=====xmlStr======"+xmlStr);
		    String response = null;
			try {
				String userV = cache.get(orderModel.getUserId()+"");
				jsonObject = JSONObject.fromObject(userV);
				String kptkt = jsonObject.get("wxToken").toString();
				Map<String, String> headers = new HashMap<String, String>();
				headers.put("_kptkt", kptkt);
				headers.put("_kpusrId", orderModel.getUserId()+"");
				headers.put("platform", SourceType.SOURCE_WX);
				xmlStr= new String(xmlStr.getBytes(), "utf-8");
				response = AiwHttpUtils.doPost(TRADE.TRADE_WT_ORDER_URL,xmlStr);
				log.info("====下单结果  response:"+response.toString());
			} catch (Exception e) {
				log.info("==error==="+e.getMessage());
			}  
        }
        
        
	}
		
	public static void main(String[] args) {
		//System.out.println(Md5Utils.getMD5("liu123456"));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stockCode", "VMBTE");
		map.put("orderType", "WT_BUY");
		map.put("userId", "172");
		map.put("opNum", "1");
		map.put("opAmt", "1.327");
		map.put("qdCode", "XF");
		System.out.println(map.toString());
		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println(jsonObject.toString());
		jsonObject = JSONObject.fromObject(jsonObject.toString());
		System.out.println(jsonObject.getString("stockCode").toString());
		
	    String xmlStr = WxPayService.createLinkString(map);
	    System.out.println(xmlStr);
	    try {
			Map<String, String> headers = new HashMap<String, String>();
			headers.put("_kptkt", "2844BED7AEBE0648716EF9118D652BE1");
			headers.put("_kpusrId", "172");
			headers.put("platform", "PC");
	    	String url = "http://test.kaipai.net/xf-trade-web/service/proxy/wtStockOrder";
	    	//String response = AiwHttpsUtils.post(url, null,xmlStr, headers);
	    	xmlStr= new String(xmlStr.getBytes(), "utf-8");
			String response = AiwHttpUtils.doPost(url,xmlStr,headers);
			System.out.println(response);
	    } catch (Exception e) {
			// TODO: handle exception
	    	System.out.println(e.getMessage());
		}
	}
	
	
	
}
