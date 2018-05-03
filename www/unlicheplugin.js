// Empty constructor
function UnlichePlugin() {}


/**
 * @function initUnliche
 * @summary Initializes the Unliche SDK.
 *
 * @param {string} unlicheAPIKey  Unliche API key
 */
UnlichePlugin.prototype.initEvent = function(unlicheAPIKey) {
    console.log("UnlichePlugin.js: Calling initUnliche");
    cordova.exec(null, null, "UnlichePlugin", "initEvent", [unlicheAPIKey]);
    return this;
};

/**
 * @function openEvent
 * @summary call when app is open.
 *
 */
UnlichePlugin.prototype.openEvent = function() {
    console.log("UnlichePlugin.js: Calling openEvent");
    cordova.exec(null, null, "UnlichePlugin", "openEvent", null);
    return this;
};

/**
 * @function setCustomEvent
 * @summary track custom event in Unliche SDK.
 *
 * @param {int} eventId  Unliche event id
 */
UnlichePlugin.prototype.setCustomEvent = function(eventId) {
    console.log("UnlichePlugin.js: Calling setCustomEvent");
    cordova.exec(null, null, "UnlichePlugin", "setCustomEvent", [eventId]);
    return this;
};

/**
 * @function setCustomEventWithParams
 * @summary track custom event with additional params in Unliche SDK.
 *
 * @param {int} eventId  Unliche event id
 * @param {String} eventId  Unliche additional param1
 * @param {String} eventId  Unliche additional param2
 * @param {String} eventId  Unliche additional param3
 * @param {String} eventId  Unliche additional param4
 * @param {String} eventId  Unliche additional param5
 */
UnlichePlugin.prototype.setCustomEventWithParams = function(eventId, param1, param2, param3, param4, param5) {
    console.log("UnlichePlugin.js: Calling setCustomEventParams");
    cordova.exec(null, null, "UnlichePlugin", "setCustomEventParams", [eventId, param1, param2, param3, param4, param5]);
    return this;
};

/**
 * @function setUserId
 * @summary set user id in Unliche SDK.
 *
 * @param {String} userId  User user id
 */
UnlichePlugin.prototype.setUserId = function(userId) {
    console.log("UnlichePlugin.js: Calling setUserId");
    cordova.exec(null, null, "UnlichePlugin", "setUserId", [userId]);
    return this;
};

/**
 * @function setUserName
 * @summary set user name in Unliche SDK.
 *
 * @param {String} userName  User username
 */
UnlichePlugin.prototype.setUserName = function(userName) {
    console.log("UnlichePlugin.js: Calling setUserName");
    cordova.exec(null, null, "UnlichePlugin", "setUserName", [userName]);
    return this;
};

/**
 * @function setPhoneNumber
 * @summary set user phone number in Unliche SDK.
 *
 * @param {String} userId  User user phone number
 */
UnlichePlugin.prototype.setPhoneNumber = function(phoneNumber) {
    console.log("UnlichePlugin.js: Calling setPhoneNumber");
    cordova.exec(null, null, "UnlichePlugin", "setPhoneNumber", [phoneNumber]);
    return this;
};

/**
 * @function setUninstallEvent
 * @summary set uninstall token in Unliche SDK.
 *
 * @param {String} pushToken  User push token 
 */
UnlichePlugin.prototype.setUninstallEvent = function(pushToken) {
    console.log("UnlichePlugin.js: Calling setUninstallEvent");
    cordova.exec(null, null, "UnlichePlugin", "setUninstallEvent", [pushToken]);
    return this;
};


// Installation constructor that binds ToastyPlugin to window
UnlichePlugin.install = function() {
  if (!window.plugins) {
    window.plugins = {};
  }
  window.plugins.unlichePlugin = new UnlichePlugin();
  return window.plugins.unlichePlugin;
};
cordova.addConstructor(UnlichePlugin.install);
