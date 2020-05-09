package com.makersmind.web.authenticate.google.impl;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.makersmind.web.authenticate.google.service.IDTokenVerifier;
import com.makersmind.web.authenticate.google.util.AuthConfig;
import com.makersmind.web.authenticate.google.util.HttpUtil;
import java.net.Proxy;
import java.util.Collections;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoogleIDTokenVerifier implements IDTokenVerifier {
  private static final Logger logger =
      LoggerFactory.getLogger(GoogleIDTokenVerifier.class);

  public GoogleIdToken verify(String token) {
    GoogleIdToken idToken = null;
    try {

      //Get the client id from your internal config. Your config should be environment specific
      Map<String, Object> credentials = (Map<String, Object>) AuthConfig.get("web");
      String clientId = credentials.get("client_id").toString();

      //Transporter for your program to reach out to google certificate url to
      // fetch public cert for signature verification
      Proxy proxy = HttpUtil.getProxy();
      HttpTransport transporter = new NetHttpTransport.Builder()
          .setProxy(proxy)
          .build();

      //Getting the verifier object
      GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transporter,
          new JacksonFactory())
          .setAudience(Collections.singleton(clientId))
          .build();

      //verify method returns the IDToken object if signature verification successful
      idToken = verifier.verify(token);
    } catch (Exception e) {
      logger.warn("Exception " + e);
    }
    return idToken;
  }
}
