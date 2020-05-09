# googlelogin
Repository for google login demo

Usage

Step 1: Open auth_configuration_lower.json file and replace the "web" content with the one you receive from google developer console.

Step 2: Open HelloGoogleLogin.html, and edit the place where it takes the client ID. You should see a meta tage like the below
<meta name="google-signin-client_id"

Step 3: Run the HelloGoogleLogin.html using a web browser. Recomended browser is safari and  chrome (any version is fine)

Step 4: Once you done login using gmail, you should receive an IDToken. Copy the IDToken.

Step 5: Open AuthIntegrationTest.java and assigne it to "String idTokenString" variable. 

Step 6: Run the test case to verify the IDToken

Caution: If you are running from a VPN then your private network might block this verification process as it  goes to google's certificate url to fetch the public certificate. In that case  if you have a proxy then that can be setup in "proxy" attribute under auth_configuration_lower.json file.
