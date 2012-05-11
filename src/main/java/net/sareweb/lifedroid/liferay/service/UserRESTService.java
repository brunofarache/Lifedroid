package net.sareweb.lifedroid.liferay.service;

import net.sareweb.lifedroid.liferay.service.generic.LDRESTService;
import net.sareweb.lifedroid.model.User;
import net.sareweb.lifedroid.util.LDConstants;

import org.springframework.http.HttpMethod;

import android.util.Log;

public class UserRESTService extends LDRESTService<User> {

	public UserRESTService(String emailAddress, String password) {
		super(emailAddress, password);
	}

	public User getUserById(String userId) {
		String requestURL = _serviceURI + "/user/get-user-by-id/userId/" + userId;
		return run(requestURL, HttpMethod.GET);
	}
	
	public User getUserByEmailAddress(String emailAddress) {
		String requestURL = _serviceURI + "/user/get-user-by-email-address/companyId/" + LDConstants.LIFERAY_COMPANY_ID + "/emailAddress/" + emailAddress;
		Log.d(TAG, "Invoking GET " + requestURL);
		return run(requestURL, HttpMethod.GET);
	}
	
	public User addUser(long companyId, boolean autoPassword, String password1, String password2, 
						boolean autoScreenName, String screenName, String emailAddress, long facebookId, 
						String openId, String locale, String firstName, String middleName, 
						String lastName, int prefixId, int suffixId, boolean male, int birthdayMonth, 
						int birthdayDay, int birthdayYear, String jobTitle, long[] groupIds, 
						long[] organizationIds, long[] roleIds, long[] userGroupIds, boolean sendEmail){ 
		String requestURL = _serviceURI + "/user/add-user";
		requestURL = addParamToRequestURL(requestURL, "companyId", companyId);
		requestURL = addParamToRequestURL(requestURL, "autoPassword", autoPassword);
		requestURL = addParamToRequestURL(requestURL, "password1", password1);
		requestURL = addParamToRequestURL(requestURL, "password2", password2);
		requestURL = addParamToRequestURL(requestURL, "autoScreenName", autoScreenName);
		requestURL = addParamToRequestURL(requestURL, "screenName", screenName);
		requestURL = addParamToRequestURL(requestURL, "emailAddress", emailAddress);
		requestURL = addParamToRequestURL(requestURL, "facebookId", facebookId);
		requestURL = addParamToRequestURL(requestURL, "openId", openId);
		requestURL = addParamToRequestURL(requestURL, "locale", locale);
		requestURL = addParamToRequestURL(requestURL, "firstName", firstName);
		requestURL = addParamToRequestURL(requestURL, "middleName", middleName);
		requestURL = addParamToRequestURL(requestURL, "lastName", lastName);
		requestURL = addParamToRequestURL(requestURL, "prefixId", prefixId);
		requestURL = addParamToRequestURL(requestURL, "suffixId", suffixId);
		requestURL = addParamToRequestURL(requestURL, "male", male);
		requestURL = addParamToRequestURL(requestURL, "birthdayMonth", birthdayMonth);
		requestURL = addParamToRequestURL(requestURL, "birthdayDay", birthdayDay);
		requestURL = addParamToRequestURL(requestURL, "birthdayYear", birthdayYear);
		requestURL = addParamToRequestURL(requestURL, "jobTitle", jobTitle);
		requestURL = addParamToRequestURL(requestURL, "groupIds", null);
		requestURL = addParamToRequestURL(requestURL, "organizationIds", null);
		requestURL = addParamToRequestURL(requestURL, "roleIds", null);
		requestURL = addParamToRequestURL(requestURL, "userGroupIds", null);
		requestURL = addParamToRequestURL(requestURL, "sendEmail", sendEmail);
		requestURL = addParamToRequestURL(requestURL, "serviceContext", null);
		return null;
	}
	
	@Override
	public void setPorltetContext() {
		
	}

}
