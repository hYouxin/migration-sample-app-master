package com.acme.anvil.service;

import java.rmi.RemoteException;
import java.util.Date;
//import java.util.concurrent.TimeUnit;

//import javax.ejb.Stateless;
//import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.inject.Inject;
import javax.transaction.InvalidTransactionException;
import javax.transaction.SystemException;

import org.apache.log4j.Logger;
//import org.jboss.ejb3.annotation.TransactionTimeout;

import com.acme.anvil.service.jms.LogEventPublisher;
import com.acme.anvil.vo.Item;
import com.acme.anvil.vo.LogEvent;

public class ItemLookupBean implements SessionBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = Logger.getLogger(ItemLookup.class);
	
	@Inject
	LogEventPublisher logEventPublisher;
	
	public Item lookupItem(long id) throws SystemException, InvalidTransactionException {
		LOG.info("Calling lookupItem.");
		
		//stubbed out.
		Item item = new Item();
		item.setId(id);
		
		final LogEvent le = new LogEvent(new Date(), "Returning Item: "+id); 
		logEventPublisher.publishLogEvent(le);
		
		return item;
	}
/*	
	public void ejbActivate(SessionBean bean) throws EJBException, RemoteException {
		LOG.debug(bean + " activate");
	}
	
	public void ejbPassivate(SessionBean bean) throws EJBException, RemoteException {
		LOG.debug(bean + " passivate");
	}
*/
	private SessionContext ctx;
	public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }
	
	public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbCreate() {
    }

    public void ejbRemove() {
    }	
}
