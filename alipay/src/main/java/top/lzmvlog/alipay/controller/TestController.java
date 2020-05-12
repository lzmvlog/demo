package top.lzmvlog.alipay.controller;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.lzmvlog.alipay.configuration.AlipayConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ShaoJie
 * @Date 2019/11/19
 */
@Controller
@EnableConfigurationProperties(AlipayConfig.class)
public class TestController {

    @Autowired
    AlipayConfig alipayConfig;

    @GetMapping("")
    public String index() {
        return "index";
    }

    @ResponseBody
    @GetMapping("success")
    public String success(Model model, HttpServletRequest request) {
        String out_trade_no = request.getParameter("out_trade_no");
        String total_amount = request.getParameter("total_amount");
        Map<String, String> map = new HashMap<>();
        map.put("out_trade_no", out_trade_no);
        map.put("total_amount", total_amount);
        String s = JSON.toJSONString(map);
//        model.addAttribute("order", out_trade_no);
        return s;
    }

    @PostMapping("pay")
    public void pay(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(alipayConfig.getUrl(), alipayConfig.getApp_id(), alipayConfig.getApp_private_key(),
                alipayConfig.getFormat(), alipayConfig.getCharset(), alipayConfig.getAlipay_public_key(), alipayConfig.getSign_type());
        //创建API对应的request
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        //在公共参数中设置回跳和通知地址
        alipayRequest.setReturnUrl("http://127.0.0.1:8090/success");
        alipayRequest.setNotifyUrl("http://127.0.0.1:8090/success");
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = request.getParameter("WIDout_trade_no");
        // 付款金额，必填
        String total_amount = request.getParameter("WIDtotal_amount");
        // 订单名称，必填
        String subject = request.getParameter("WIDsubject");
        // 商品描述，
        String body = request.getParameter("WIDbody");
        Map<String, String> map = new HashMap<>();
        map.put("out_trade_no", out_trade_no);
        map.put("total_amount", total_amount);
        map.put("subject", subject);
        map.put("body", body);
        map.put("timeout_express", "10m");
        map.put("product_code", "FAST_INSTANT_TRADE_PAY");
//        map.put("version","10");
        String s = JSON.toJSONString(map);
//        System.out.println(s);
        alipayRequest.setBizContent(s);
        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=" + alipayConfig.charset);
        response.getWriter().write(form);//直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();
    }

}
