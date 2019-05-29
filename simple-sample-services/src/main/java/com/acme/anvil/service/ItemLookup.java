package com.acme.anvil.service;

import com.acme.anvil.vo.Item;

public interface ItemLookup extends javax.ejb.EJBObject {

	public Item lookupItem(long id) throws java.rmi.RemoteException;
}
