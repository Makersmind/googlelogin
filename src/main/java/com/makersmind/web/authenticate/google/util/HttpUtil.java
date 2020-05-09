package com.makersmind.web.authenticate.google.util;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtil {

  private static final Logger logger =
      LoggerFactory.getLogger(HttpUtil.class);

  /**
   * Get proxy host and port
   *
   * @return
   */
  public static Proxy getProxy() {
    Map<String, Object> proxy = (Map<String, Object>) AuthConfig.get("proxy");

    if (proxy != null) {
      String host = proxy.get("host") != null ? proxy.get("host").toString() : null;
      String port = proxy.get("port") != null ? proxy.get("port").toString() : null;

      if (StringUtils.isNotEmpty(host) && StringUtils.isNotEmpty(port)) {
        return new java.net.Proxy(Proxy.Type.HTTP,
            new InetSocketAddress(host, Integer.parseInt(port)));
      } else {
        return null;
      }
    } else {
      return null;
    }
  }
}
