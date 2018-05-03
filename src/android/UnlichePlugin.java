package com.rappier.cordova.plugin;
// The native Toast API
import android.widget.Toast;
// Cordova-required packages
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.rappier.unlichesdk.unlichelib.mainsdkclasses.Unliche;

public class UnlichePlugin extends CordovaPlugin {
  private static final String DURATION_LONG = "long";
  public static final String INIT = "initEvent";
  public static final String OPENEVENT = "openEvent";
	public static final String CUSTOMEVENT = "setCustomEvent";
	public static final String CUSTOMEVENTPARAMS = "setCustomEventParams";
	public static final String USERID = "setUserId";
	public static final String USERNAME = "setUserName";
	public static final String PHONENUMBER = "setPhoneNumber";
	public static final String UNINSTALLEVENT = "setUninstallEvent";

  private Unliche unliche;

  @Override
  public boolean execute(String action, JSONArray args,
    final CallbackContext callbackContext) {
      // Verify that the user sent a 'show' action
      //if (!action.equals("show")) {
        //callbackContext.error("\"" + action + "\" is not a recognized action.");
      //  return false;
      //}

	if (INIT.equals(action)) {
            if (unliche == null) {
                //String advertiserId = args.optString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
		    public void run() {
		        String advertiserKey = args.optString(0);
		        unliche =  Unliche.initEvent(cordova.getActivity().getApplicationContext(), advertiserKey);
		}
		});
              
            }else{
			callbackContext.error("\"" + action + "\" is already done.");
		}
            return true;

        }else if (OPENEVENT.equals(action)) {
		cordova.getActivity().runOnUiThread(new Runnable() {
		    public void run() {
		      Unliche.setOpenEvent(cordova.getActivity().getApplicationContext());
		    }
		});
		return true;
	}else if (CUSTOMEVENT.equals(action)) {
		cordova.getActivity().runOnUiThread(new Runnable() {
		    public void run() {
			int eventId = args.optInt(0);
		      	Unliche.setCustomEvent(cordova.getActivity().getApplicationContext(), eventId);
		    }
		});
		return true;
	}else if (CUSTOMEVENTPARAMS.equals(action)) {
		cordova.getActivity().runOnUiThread(new Runnable() {
		    public void run() {		
			int eventId = args.optInt(0);
			String param1 = args.optString(1);
			String param2 = args.optString(2);
			String param3 = args.optString(3);
			String param4 = args.optString(4);
			String param5 = args.optString(5);
		      	Unliche.setCustomEvent(cordova.getActivity().getApplicationContext(), eventId, param1, param2, param3, param4, param5);
		    }
		});
		return true;
	}else if (USERID.equals(action)) {
		cordova.getActivity().runOnUiThread(new Runnable() {
		    public void run() {
			String userId = args.optString(0);
		      	Unliche.setUserId(userId);
		    }
		});
		return true;
	}else if (USERNAME.equals(action)) {
		cordova.getActivity().runOnUiThread(new Runnable() {
		    public void run() {
			String userName = args.optString(0);
		      	Unliche.setUserName(userName);
		    }
		});
		return true;
	}else if (PHONENUMBER.equals(action)) {
		cordova.getActivity().runOnUiThread(new Runnable() {
		    public void run() {
			String phoneNumber = args.optString(0);
		      	Unliche.setPhoneNumber(phoneNumber);
		    }
		});
		return true;
	}else if (UNINSTALLEVENT.equals(action)) {
		cordova.getActivity().runOnUiThread(new Runnable() {
		    public void run() {
			String pushToken = args.optString(0);
		      	Unliche.setUninstallEvent(cordova.getActivity().getApplicationContext(), pushToken);
		    }
		});
		return true;
	}

      // Send a positive result to the callbackContext
      PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
      callbackContext.sendPluginResult(pluginResult);
      return true;
  }
}
