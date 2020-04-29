package integration;

import java.util.*;
import java.time.*;
import model.Sale;

/**
 * A class to represent the accounting system that logs the sales
 */
public class AccountingSystem {
	private HashMap<Sale, LocalDateTime> saleLog = new HashMap<>();

    /**
     * Creates the accounting system
     */
	public AccountingSystem() {

	}

    /**
     * Registers a sale in a hash map where the sale is the key and the time of sale the value
     * @param sale The sale that will be logged
     */
	public void registerSale(Sale sale) {
		LocalDateTime timeOfSale = LocalDateTime.now();
		saleLog.put(sale, timeOfSale);

	}

}
