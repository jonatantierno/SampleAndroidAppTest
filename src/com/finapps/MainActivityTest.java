package com.finapps;
import java.util.List;

import junit.framework.Assert;

import org.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.IOP.TransactionService;

import com.finapps.MainActivity.Transaction;

import android.webkit.DownloadListener;


@RunWith(RoboelectricSampleTestRunner.class)
public class MainActivityTest {

	MainActivity objectUnderTest = null;
	@Before
	public void setUp() throws Exception {
		objectUnderTest = new MainActivity();
	    this.objectUnderTest.getBaseContext();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testParseTransactions() {
		// Fixture
		String json = "{\"transactions\":[{\"amount\":-10,\"otherParty\":\"Pepe\",\"date\":838839299834792783},{\"amount\":210,\"otherParty\":\"Paco\",\"date\":838839234792783}]}";
// Execution
		Transaction trans = null;;
		try {
			trans = objectUnderTest.parseTransactions(json);
		} catch (JSONException e) {
			Assert.fail(e.toString());
		}
		Assert.assertNotNull(trans);
		Assert.assertEquals(-10, trans.amount);
	}

}
