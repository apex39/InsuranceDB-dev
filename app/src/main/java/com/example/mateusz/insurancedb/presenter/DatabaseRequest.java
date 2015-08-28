package com.example.mateusz.insurancedb.presenter;

import com.example.mateusz.insurancedb.model.Oc;

/**
 * Created by mateusz.bak@mobica.com on 2015-08-26.
 */
public interface DatabaseRequest {
	void login(LoginCredentials loginCredentials);
	void logout();
	void addOc(Oc oc);
	void modifyOc(Oc oc);
	void deleteOc(String ocId);
	void getOc(Oc oc);
	void getRecentOcs();
}
