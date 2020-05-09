package com.makersmind.web.authenticate.google.util;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthConfig {

  private static final String CREDENTIALS_FILE_NAME = "credentials/auth_configuration_lower.json";
  private static final Logger logger =
      LoggerFactory.getLogger(AuthConfig.class);
  private static Map<String, Object> credentialMap;
  private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

  static {
    if (credentialMap == null) {
      try {
        credentialMap = (Map<String, Object>) gson.fromJson(new String(Resources
            .toByteArray(Resources.getResource(CREDENTIALS_FILE_NAME))), Map.class);
      } catch (IOException e) {
        logger.info("Exception " + e);
      }
    }
  }

  public static Object get(String key) {
    if (credentialMap != null) {
      return credentialMap.get(key);
    } else {
      return null;
    }
  }

  public static String getString(String key) {
    if (credentialMap != null && credentialMap.get(key) instanceof String) {
      return credentialMap.get(key).toString();
    } else {
      return null;
    }
  }
}
