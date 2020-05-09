package com.makersmind.web.authenticate.google.test;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.makersmind.web.authenticate.google.impl.GoogleIDTokenVerifier;
import com.makersmind.web.authenticate.google.service.IDTokenVerifier;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthIntegrationTest {

  private static final Logger logger =
      LoggerFactory.getLogger(AuthIntegrationTest.class);
  @Test
  public void testGoogleLoginIDTokenVerification(){
    String idTokenString =
        "";

    IDTokenVerifier verifier = new GoogleIDTokenVerifier();
    GoogleIdToken idToken = (GoogleIdToken)verifier.verify(idTokenString);
    logger.info("IDTOKEN "+idToken);

    Assert.assertNotNull(idToken);
    Assert.assertNotNull(idToken.getPayload());

    Assert.assertEquals(idToken.getPayload().getIssuer(), "accounts.google.com");
    Assert.assertEquals("your_email_id", idToken.getPayload().getEmail());
  }
}
