package com.makersmind.web.authenticate.google.service;

public interface IDTokenVerifier {

  Object verify(String token);
}
