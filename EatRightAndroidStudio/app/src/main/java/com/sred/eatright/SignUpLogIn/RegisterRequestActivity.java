//package com.sred.eatright.SignUpLogIn;
//
//
//import androidx.annotation.Nullable;
////
////import com.android.volley.Response;
////import com.android.volley.toolbox.StringRequest;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class RegisterRequestActivity extends StringRequest {
//
//
//   private static final String REGISTER_REQUEST_URL ="https://eayright.000webhostapp.com/Register.php";
//   private Map<String,String> params;
//
//   public RegisterRequestActivity(String username, String useremail, String password, Response.Listener<String> listener) {
//       super(Method.POST, REGISTER_REQUEST_URL, listener, null);
//       params = new HashMap<>();
//       params.put("username", username);
//       params.put("useremail", useremail);
//       params.put("password", password);
//   }
//       @Override
//       public Map<String, String> getParams(){
//          return params;
//       }
//   }
//
