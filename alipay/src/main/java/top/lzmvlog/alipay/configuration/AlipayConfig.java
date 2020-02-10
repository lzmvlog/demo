package top.lzmvlog.alipay.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ShaoJie
 * @Date 2019/11/5
 */
@Data
@Component
@ConfigurationProperties(prefix = "ali")
public class AlipayConfig {

    public String url = null;

    public String app_id = null;

    public String app_private_key = null;

    public String format = null;

    public String charset = null;

    public String alipay_public_key = null;

    public String sign_type = null;

}
