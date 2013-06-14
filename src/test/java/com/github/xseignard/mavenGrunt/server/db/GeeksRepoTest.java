package com.github.xseignard.mavenGrunt.server.db;

import org.junit.Assert;
import org.junit.Test;

public class GeeksRepoTest {

	@Test
	public void testFind() {
		GeeksRepo repo = new GeeksRepo();
		String jsonGeeks = repo.find("java", 12, 0);
		System.out.println(jsonGeeks);
		Assert.assertNotNull(jsonGeeks);
	}
	
	@Test
	public void testFindNullLimitAndSkip() {
		GeeksRepo repo = new GeeksRepo();
		String jsonGeeks = repo.find("java", null, null);
		System.out.println(jsonGeeks);
		Assert.assertNotNull(jsonGeeks);
	}

}
