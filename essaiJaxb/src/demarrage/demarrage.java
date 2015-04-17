package demarrage;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import classes.generees.CustomerType;
import classes.generees.ObjectFactory;
import classes.generees.Root;
import classes.generees.Root.Customers;

public class demarrage {
	public static void main(String[]arg) throws JAXBException
	{
//		System.out.println("hello");
		JAXBContext monContexte = JAXBContext.newInstance(ObjectFactory.class);
		Unmarshaller monUnmarshaller = monContexte.createUnmarshaller();
		Object monObjet = monUnmarshaller.unmarshal(new File("xml/monxml.xml"));
		Root monObjetRacine = (Root) monObjet; 
		Customers mesClients = monObjetRacine.getCustomers();
		CustomerType monClient = mesClients.getCustomer().get(0);
		String monEnt = monClient.getCompanyName();
		String monContact = monClient.getContactName();
		System.out.println("nom de l'entreprise: " + monEnt);
		System.out.println("nom du contact: " + monContact);
	}
}
